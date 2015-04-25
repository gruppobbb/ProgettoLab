package view2d.render;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.MobsManager;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.ships.Ship2D;
import view2d.Drawer2D;
import view2d.assets.Assets;
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
	
	private volatile boolean running;
	private Thread viewThread;
	
	private RenderInfo info;
	private boolean limitate;
	private long renderSleepMillis;
	
	private BufferStrategy buffer;
	private int bufferStrategySize;
	private Graphics2D g;
	private Color bgColor = new Color(43,62,84);
	
	private BufferedImage screen;
	private BufferedImage background;
	private BufferedImage HUD;
	
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
		
		screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		//screen = create(width, height, true);
		//HUD = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		info = new RenderInfo();
		limitate = true;
		renderSleepMillis = 2;
		bufferStrategySize = 2;
		mobDrawer = new SpriteDrawer(Assets.SPRITE_DEFAULT);
		shipDrawer = new SpriteDrawer(Assets.SPRITE_DEFAULT);
	}
	
	/**
	 * Metodo per l'avvio del thread grafico e del frame.
	 */
	public synchronized void start(){
		running = true;
		viewThread = new Thread(this);
		//openGemePanel();					IL PANNELLO LO METTEREI IN SINGLEPLAYER, si gestisce meglio
		viewThread.start();			
	}

	//Avvio del frame contenente il canva.
	private void openGemePanel() {
		JFrame frame = new JFrame();
		//Per ora .. pi� in la facciamo che si torna al menu ...
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	public void setBackground(BufferedImage background) {
		this.background = background;
	}
	
	/**
	 * Metodo per lo stop del thread grafico.
	 */
	public synchronized void stop(){
		running = false;
//		try {
//			viewThread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	public void setMobDrawer(Drawer2D mobDrawer) {
		this.mobDrawer = mobDrawer;
	}
	
	public void setShipDrawer(Drawer2D shipDrawer) {
		this.shipDrawer = shipDrawer;
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
					//E' inutile tentare di aggiornare troppo frequentemente.
					//Si introduce quindi una pausa per dimunire il carico alla CPU.
					//Questa, quando abilitata, deve essere comunque piccola.
					//Dopotutto non si vuole "notare" a video.
					try {
						Thread.sleep(renderSleepMillis);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				refresh();
				tick(g);
				//drawHud(g);
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
		
		ArrayList<Mob> mobsToDraw = mobsManager.getMobsList();
		for (Mob mob : mobsToDraw) {
			Mob2D mob2d = (Mob2D) mob;
			mobDrawer.draw(g, mob2d.getCoordinate());
		}
		
		shipDrawer.draw(g, ship.getCoordinate());
		g.dispose();
	}
	
	
	private void drawHud(Graphics2D g){
		return;
		
		
		
		//Usare per lo HUD!
//		Composite originalComposite = g.getComposite();
//		//g.setPaint(Color.blue);
//	  	drawBackground(g);
//	  	g.setComposite(makeComposite(0.7f));
//	  	//g.setPaint(Color.red);
//	  	drawScreen(g);
//	  	g.setComposite(originalComposite);
		//Graphics2D hudGraphics = (Graphics2D) HUD.getGraphics();
		//TODO
	}
	
	
	
	private void drawBackground(Graphics2D g){
		if(background == null){
			background = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D backGraphics = (Graphics2D) background.getGraphics();
			backGraphics.setColor(bgColor);
			backGraphics.fillRect(0, 0, background.getWidth(), background.getHeight());
		}
		g.drawImage(background, 0, 0, null);
	}
	
	 private AlphaComposite makeComposite(float alpha) {
		  int type = AlphaComposite.SRC_OVER;
		  return(AlphaComposite.getInstance(type, alpha));
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
