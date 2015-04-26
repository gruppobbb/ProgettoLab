package model.spawning;

import model.MobsManager;
import model.movement.MovingLogic2D;

/**
 * Componente che si occupa della gestione dello spawning dei mob.
 * @author Max
 *
 */
public class Spawner implements Runnable {
	
	public static final int SLEEP_TIME = 500;
	private MobsManager manager;
	private MovingLogic2D mobMover;
	private SpawnLogic spawnLogic;
	private boolean toKill;
	
	public Spawner(MobsManager manager, MovingLogic2D mobMover, SpawnLogic spawnLogic) {
		super();
		this.manager = manager;
		this.mobMover = mobMover;
		this.spawnLogic = spawnLogic;
	}
	
	private void spawn() {
		manager.addMob(spawnLogic.spawnMob(mobMover));
	}
	
	@Override
	public void run() {
		while(toKill == false) {
			spawn();
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Imposta il flag che indica se il thread è da terminare.
	 */
	public void setToKill(boolean toKill) {
		this.toKill = toKill;
	}
	
	
	

}
