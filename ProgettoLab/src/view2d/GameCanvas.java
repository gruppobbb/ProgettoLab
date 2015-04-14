package view2d;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.MobsManager;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.ships.Ship2D;

/**
 * Canvas per il disegno di tutta l'area di gioco.
 * @author Max
 *
 */
public class GameCanvas extends Canvas {
	
	private static final long serialVersionUID = 2871408762813611270L;
	private Ship2D ship;
	private MobsManager mobsManager;
	private Timer updateTimer = new Timer();

	public GameCanvas(Ship2D ship, MobsManager mobsManager) {
		super();
		this.ship = ship;
		this.mobsManager = mobsManager;
		
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
		
		ArrayList<Mob> mobsToDraw = mobsManager.getMobsList();
		for (Mob mob : mobsToDraw) {
			((Mob2D) mob).draw(g);
		}
	}
	
	
	
	
	

}
