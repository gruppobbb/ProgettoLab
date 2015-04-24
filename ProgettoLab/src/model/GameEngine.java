package model;

import java.util.ArrayList;
import java.util.Observable;

import model.mobs.Mob;
import model.movement.Moveable;
import model.ships.Ship;
import audio.AudioPlayer;

/**
 * Componente che si occupa di far progredire il gioco, muovendo i mob e controllando le collisioni dei mob con la ship.
 * @author Max
 *
 */
public class GameEngine extends Observable implements Runnable{
	
	private final long SLEEP_TIME = 20;
	private MobsManager mobsManager;
	private Ship ship;
	private Coordinate bounds;
	private boolean collided = false;
	
	public GameEngine(MobsManager mobsManager, Ship ship, Coordinate viewBounds) {
		this.mobsManager = mobsManager;
		this.ship = ship;
		this.bounds = viewBounds;
	}
	
	
	public void run() {
		while(true) {
			ArrayList<Mob> mobs = mobsManager.getMobsList();
			
			int shipX = ship.getCoordinate().getX();
			int shipY = ship.getCoordinate().getY();
			int shipZ = ship.getCoordinate().getZ();
			double shipCollisionRay = ship.getCollisionRay();
			
			for (Mob mob : mobs) {
				Moveable m = (Moveable) mob;
				m.move();
				
				//controllo collisione del mob con la navicella
				
				removeOutOfBoundsMobs(mob);	//questo metodo deve essere invocato prima del check delle collisioni
											//(inutile controllare se collide quando è fuori dal campo)
				
				checkCollisionWithShip(shipX, shipY, shipZ, shipCollisionRay,
						mob);
			}
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//controlla la collisione con la ship
	private void checkCollisionWithShip(int shipX, int shipY, int shipZ,
			double shipCollisionRay, Mob mob) {
		int mobX = mob.getCoordinate().getX();
		int mobY = mob.getCoordinate().getY();
		int mobZ = mob.getCoordinate().getZ();
		double mobCollisionRay = mob.getCollisionRay();
		double distance = Math.sqrt(	(mobX - shipX) * (mobX - shipX) +	
										(mobY - shipY) * (mobY - shipY) +	
										(mobZ - shipZ) * (mobZ - shipZ));
		AudioPlayer player = new AudioPlayer("res/bgm/ship_explosion.wav");
		if(distance < shipCollisionRay + mobCollisionRay) {
			System.out.println("! COLLISION DETECTED @ " + System.currentTimeMillis());
			
			player.play();
			setCollided(true);
		}
	}

	//rimuove i mob che sono fuori dai confini specificati (da bounds)
	private void removeOutOfBoundsMobs(Mob mob) {
		if(mob.getCoordinate().getY() > bounds.getY() || mob.getCoordinate().getX() > bounds.getX() || mob.getCoordinate().getX() > bounds.getX()) {
			//DEBUG CODE
			System.out.println("X Mob " + mob.toString() + " has to be killed");
			//
			mobsManager.removeMob(mob);
		}
	}


	public boolean isCollided() {
		return collided;
	}


	public void setCollided(boolean collided) {
		this.collided = collided;
		setChanged();
		notifyObservers();
	}


	
	
	

}
