package model.movement;

import java.util.ArrayList;

import model.MobsManager;
import model.mobs.Mob;

/**
 * Componente che si occupa di muovere periodicamente i {@link Moveable}.
 * @author Max
 *
 */
public class Mover implements Runnable {
	
	private final long SLEEP_TIME = 20;
	private MobsManager mobsManager;
	
	public Mover(MobsManager mobsManager) {
		this.mobsManager = mobsManager;
	}
	
	@Override
	public void run() {
		while(true) {
			ArrayList<Mob> mobsToMove = mobsManager.getMobsList();
			for (Mob mob : mobsToMove) {
				Moveable m = (Moveable) mob;
				m.move();
			}
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
