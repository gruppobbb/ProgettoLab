package view2d.render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import control.Controller2D;
import model.MobsManager;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.ships.Ship2D;

/**
 * Classe per la gestione delle chiamate draw e render(?).
 * @author Jan
 *
 */
public class RGameCanvas extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 2871408762813611270L;
	
	private double FPS;
	
	private Ship2D ship;
	private MobsManager mobsManager;
	
	private volatile boolean running;
	private Thread renderThread;
	
	private Render2D render;
	private RenderInfo info;
	private boolean renderSync;
	private boolean limitate;
	private long renderSleepMillis;
	
	private BufferStrategy buffer;
	private int bufferStrategySize;
	private Graphics2D g;
	private Color bgColor; 
	
	private BufferedImage screen;
	private BufferedImage background;
	private int[] pixels;
	
	private GraphicsConfiguration config = GraphicsEnvironment.getLocalGraphicsEnvironment()
    														  .getDefaultScreenDevice() 
    														  .getDefaultConfiguration();
	
	
	public RGameCanvas(int width, int height ,Ship2D ship, MobsManager mobsManager) {
		super();
		this.FPS = 60;
		this.ship = ship;
		this.mobsManager = mobsManager;
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		
		//screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		screen = create(width, height, true);
		pixels = ((DataBufferInt)screen.getRaster().getDataBuffer()).getData();
		
		//background = create(width, height, false);
		
		info = new RenderInfo();
		render = new Render2D(pixels, width, height);
		limitate = true;
		renderSleepMillis = 2;
		
		bufferStrategySize = 2;
		bgColor = new Color(43,62,84);
	}
	
	/**
	 * Metodo per l'avvio del thread grafico.
	 */
	public synchronized void start(){
		running = true;
		renderThread = new Thread(this);
		renderThread.start();
	}
	
	/**
	 * Metodo per lo stop del thread grafico.
	 */
	public synchronized void stop(){
		running = false;
		try {
			renderThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		
		Graphics2D screenGraphics = (Graphics2D) screen.getGraphics();
		
		int ticks = 0;
		int frames = 0 ;
		long lastTimer = System.currentTimeMillis();
		double nsPerUpdate = 1000000000D/FPS;
		long lastTime = System.nanoTime();
		double delta = 0;
		
		long now;
		boolean needRender = true;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime )/nsPerUpdate;
			lastTime = now;
			
			if( renderSync ){
				//Sincronizzazione tra ticks e render.
				//Se disattivato, si faranno più aggiornamenti per ogni chiamata di render.
				//Con piu' aggiornamenti si ha che quando serve renderizzare per soddisfare gli FPS
				//richiesti, si ha già tutto pronto, e non si deve elaborare al momento.
				needRender = false;
			}
			
			while( delta >= 1){
				ticks++;
				tick(screenGraphics);
				delta -= 1;
				needRender = true;
			}
			
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
			
			
			if(needRender){
				frames++;
				refresh();
			}
			
			if( (System.currentTimeMillis() - lastTimer ) >= 1000){
				lastTimer+=1000;
				info.setLastInfo(frames, ticks);
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	
	//Aggiornamento del frame da mandare a video.
	private void tick(Graphics2D graphics2d){
		
		ArrayList<Mob> mobsToDraw = mobsManager.getMobsList();
		for (Mob mob : mobsToDraw) {
			((Mob2D) mob).draw(graphics2d);
		}
		
		ship.draw(graphics2d);
		
		graphics2d.dispose();
	}
	
	
	//Refresh del video.
	private void refresh(){
		
		buffer = getBufferStrategy();
		
		if(buffer == null){
			createBufferStrategy(bufferStrategySize);
			return;
		}
		
		//do{
			g = (Graphics2D)buffer.getDrawGraphics();
			g.setColor(bgColor);
			g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
			//g.drawImage(screen, 0, 0, screen.getWidth(), screen.getHeight(), null);
			g.drawImage(screen, 0, 0, null);
			g.dispose();
	    	g = null;
    		buffer.show();
		//}while(!updateScreen());
	}
	
	private boolean updateScreen() { 
    	g.dispose();
    	g = null;
    	try { 
    		buffer.show();
    		Toolkit.getDefaultToolkit().sync(); 
    		return (!buffer.contentsLost());
 
    	} catch (NullPointerException e) {
    		return true; 
 
    	} catch (IllegalStateException e) {
    		return true; 
    	} 
    }
	
	// create a hardware accelerated image 
    public final BufferedImage create(final int width, final int height,
    		final boolean alpha) {
    	return config.createCompatibleImage(width, height, alpha
    			? Transparency.TRANSLUCENT : Transparency.OPAQUE); 
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addInfoObserver(Observer o){
		info.addObserver(o);
	}
	
	class Render2D {
		private int[] pixels;
		private int width, height;
		
		public Render2D(int[] pixels, int width, int height) {
			this.pixels = pixels;
			this.width = width;
			this.height = height;
		}
	}
	
	
	class RenderInfo extends Observable{
		private int lastFPS;
		private int lastTicks;
		
		public void setLastInfo(int lastFPS, int lastTicks) {
			this.lastFPS = lastFPS;
			this.lastTicks = lastTicks;
			setChanged();
			notifyObservers();
		}
		
		public int getLastFPS() {
			return lastFPS;
		}
		
		public int getLastTicks() {
			return lastTicks;
		}
	}
}
