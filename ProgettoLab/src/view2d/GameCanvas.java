package view2d;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import model.ships.Ship2D;

/**
 * Canvas per il disegno di tutta l'area di gioco.
 * @author Max
 *
 */
public class GameCanvas extends Canvas {
	
	private static final long serialVersionUID = 2871408762813611270L;
	private Ship2D ship;
	private Timer updateTimer = new Timer();

	public GameCanvas(Ship2D ship) {
		super();
		this.ship = ship;
		
		updateTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		}, 0, 17);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ship.draw(g);
	}
	
	
	
	
	

}
