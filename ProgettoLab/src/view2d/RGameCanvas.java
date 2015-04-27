package view2d;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import assetsPc.Assets;
import model.MobsManager;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.scores.ScoreCalculator;
import model.ships.Ship2D;
import view2d.drawers.SpriteDrawer;

/**
 * Classe per la visualizzazione dell'interfaccia grafica.
 * @author Jan
 */
public class RGameCanvas extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 2871408762813611270L;
	
	
	private int width, height;
	
	private Ship2D ship;
	private MobsManager mobsManager;
	private ScoreCalculator scoreCalculator;
	
	private volatile boolean running;
	private Thread viewThread;
	
	private RenderInfo info;
	private boolean limitate;
	private long renderSleepMillis;
	
	private BufferStrategy buffer;
	private int bufferStrategySize;
	private Graphics2D g;
	private Color bgColor = new Color(43,62,84);
	
	private BufferedImage background;
	private BufferedImage gameScene;
	private Graphics2D gameSceneGraphics;
	private BufferedImage hud;
	private Graphics2D hudGraphics;
	
	private boolean debug;
	private GraphicsConfiguration config = GraphicsEnvironment.getLocalGraphicsEnvironment()
    														  .getDefaultScreenDevice() 
    														  .getDefaultConfiguration();
	
	private Drawer2D mobDrawer;
	private Drawer2D shipDrawer;
	
	public RGameCanvas(int width, int height ,Ship2D ship, MobsManager mobsManager) {
		super();
		setFocusable(true);
		this.width = width;
		this.height = height;
		this.ship = ship;
		this.mobsManager = mobsManager;
		setBackground(Color.red);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		
		info = new RenderInfo();
		limitate = true;
		renderSleepMillis = 2;
		bufferStrategySize = 2;
		mobDrawer = new SpriteDrawer(Assets.SPRITE_DEFAULT);
		shipDrawer = new SpriteDrawer(Assets.SPRITE_DEFAULT);
		
		gameScene = create(width, height, true);
		gameSceneGraphics = (Graphics2D)gameScene.getGraphics();
		hud = create(width, height, true);
		hudGraphics = (Graphics2D) hud.getGraphics();
		
	}
	
	public RGameCanvas(int width, int height ,Ship2D ship, MobsManager mobsManager, ScoreCalculator scoreCalculator) {
		this(width, height ,ship, mobsManager);
		this.scoreCalculator = scoreCalculator;
		setScoreMetrics(width/2-150, height-50, 300, 50);
	}
	
	/**
	 * Metodo per l'avvio del thread grafico e del frame.
	 */
	public synchronized void start(){
		running = true;
		viewThread = new Thread(this);
		viewThread.start();			
	}

	
	@Override
	public void run() {
		int frames = 0;
		long renderTimeSum = 0;
		long renderTimeStart = System.currentTimeMillis();
		long lastRenderTime;
		int n = 0;
		long now;
		long lastTimer = System.currentTimeMillis();
		
		limitate = true;
		
		createBufferStrategy(bufferStrategySize);
		do{buffer = getBufferStrategy();}while(buffer == null);
		
		while(true){
			if(running){
				if(limitate){
					try {
						Thread.sleep(renderSleepMillis);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				refresh();
				tick(g);
				g.dispose();
				
				if(debug){
					frames++;
					n++;
					now = System.currentTimeMillis();
					lastRenderTime =  now - renderTimeStart;
					renderTimeSum += lastRenderTime;
					if( (System.currentTimeMillis() - lastTimer ) >= 1000){
						lastTimer+=1000;
						info.setLastInfo(frames,renderTimeSum/n);
						frames = 0;
						n = 0;
						renderTimeSum = 0;
					}
					renderTimeStart = now;
				}
			}else{
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//Refresh del video.
	private void refresh(){
		buffer.show();
		g = (Graphics2D)buffer.getDrawGraphics();
	}
	
	// create a hardware accelerated image 
    public final BufferedImage create(final int width, final int height,
    		final boolean alpha) {
    	return config.createCompatibleImage(width, height, alpha
    			? Transparency.TRANSLUCENT : Transparency.OPAQUE); 
    }
	
	//Aggiornamento del frame da mandare a video.
	private void tick(Graphics2D g){
		drawBackground(g);
		drawEntities(g);
		drawHUD(g);
	}
	
	
	private void drawBackground(Graphics2D g){
		if(background == null){
			background = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D backGraphics = (Graphics2D) background.getGraphics();
			backGraphics.setColor(bgColor);
			backGraphics.fillRect(0, 0, background.getWidth(), background.getHeight());
			return;
		}
		g.drawImage(background, 0, 0, null);
	}
	
	private void drawEntities(Graphics2D g){
		ArrayList<Mob> mobsToDraw = mobsManager.getMobsList();
		for (Mob mob : mobsToDraw) {
			Mob2D mob2d = (Mob2D) mob;
			mobDrawer.draw(g, mob2d.getCoordinate());
		}
		shipDrawer.draw(g, ship.getCoordinate());
	}
	
	
	
	
	

	public void setBackground(BufferedImage background) {
		this.background = background;
	}
	
	/**
	 * Metodo per lo stop del thread grafico.
	 */
	public synchronized void stop(){
		running = false;
	}
	
	public void setMobDrawer(Drawer2D mobDrawer) {
		this.mobDrawer = mobDrawer;
	}
	
	public void setShipDrawer(Drawer2D shipDrawer) {
		this.shipDrawer = shipDrawer;
	}
	
	int xScoreDraw, yScoreDraw;
	int scoreAreaWidth, scoreAreaHeight;
	boolean needCentring;
	private void centreScore(Graphics g, String formattedScore) {
	    FontMetrics fm = g.getFontMetrics();
	    xScoreDraw = ( scoreAreaWidth - fm.stringWidth(formattedScore)) / 2;
	    yScoreDraw = (fm.getAscent() + ( scoreAreaHeight - fm.getAscent() + fm.getDescent() ) / 2);
	}
	
	
	public void setScoreMetrics(int xScoreArea, int yScoreArea, int scoreAreaWidth, int scoreAreaHeight){
		this.xScoreArea = xScoreArea;
		this.yScoreArea = yScoreArea;
		this.scoreAreaWidth = scoreAreaWidth;
		this.scoreAreaHeight = scoreAreaHeight;
	}
	
	private Color scoreColor = new Color(255,255,255,255);
	private int xScoreArea, yScoreArea;
	private void drawHUD(Graphics2D g){
		clearGraphics(hudGraphics);
		if(scoreCalculator!=null){
			drawScore(hudGraphics);
		}
		g.drawImage(hud,0,0, null);
	}
	
	private void drawScore(Graphics2D graphics2d){
		graphics2d.setFont(Assets.getLoader().getFont(Assets.FONT_GENERAL).getSizedFont(32f));
		graphics2d.setColor(scoreColor);
		graphics2d.drawRect(xScoreArea, yScoreArea, scoreAreaWidth, scoreAreaHeight);
		String formattedScore = scoreCalculator.getScore()+"";
		centreScore(graphics2d,formattedScore);
		graphics2d.drawString(formattedScore, xScoreArea+xScoreDraw, yScoreArea+ yScoreDraw);
	}
	
	
	private void clearGraphics(Graphics2D graphics2d){
		graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR)); 
		graphics2d.setBackground(new Color(255,255,255,0));
		graphics2d.clearRect(0, 0, width, height); 
		graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public RenderInfo getRenderinfo(){
		return info;
	}
	
	public class RenderInfo extends Observable{
		private int lastFPS;
		private double renderTimeAVG;
		
		@Override
		public synchronized void addObserver(Observer o) {
			debug = true;
			super.addObserver(o);
		}
		
		public void setLastInfo(int lastFPS, double renderTimeAVG) {
			this.lastFPS = lastFPS;
			this.renderTimeAVG = renderTimeAVG;
			setChanged();
			notifyObservers();
		}
		
		public int getLastFPS() {
			return lastFPS;
		}
		
		public double getRenderTimeAVG() {
			return renderTimeAVG;
		}
		
		@Override
		public String toString() {
			return ">[FPS:"+this.lastFPS+"][RT_AVG:"+this.renderTimeAVG+"]";
		}
	}
}
