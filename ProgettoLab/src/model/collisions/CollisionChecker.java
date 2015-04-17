package model.collisions;

import java.util.ArrayList;

import model.MobsManager;
import model.mobs.Mob;
import model.ships.Ship;

public class CollisionChecker implements Runnable {
	
	private final long SLEEP_TIME = 150;
	private MobsManager mobsManager;
	private Ship ship;
	
	public CollisionChecker(MobsManager mobsManager, Ship ship) {
		this.mobsManager = mobsManager;
		this.ship = ship;
	}
	
	
	@Override
	public void run() {
		while(true) {
			
			int shipX = ship.getCoordinate().getX();
			int shipY = ship.getCoordinate().getY();
			int shipZ = ship.getCoordinate().getZ();
			double shipCollisionRay = ship.getCollisionRay();
			
			ArrayList<Mob> mobsToCheck = mobsManager.getMobsList();
			for (Mob mob : mobsToCheck) {
				//controllo collisione del mob con la navicella
				int mobX = mob.getCoordinate().getX();
				int mobY = mob.getCoordinate().getY();
				int mobZ = mob.getCoordinate().getZ();
				double mobCollisionRay = mob.getCollisionRay();
				
				double distance = Math.sqrt(	(mobX - shipX) * (mobX - shipX) +	
												(mobY - shipY) * (mobY - shipY) +	
												(mobZ - shipZ) * (mobZ - shipZ));

				if(distance < shipCollisionRay + mobCollisionRay) {
					System.out.println("COLLISION DETECTED @ " + System.currentTimeMillis());
				}
			}
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
