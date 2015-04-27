package model.spawning;

import model.MobsManager;
import model.movement.MovingLogic2D;

/**
 * Componente che si occupa della gestione dello spawning dei mob.
 * @author Max
 */
public class Spawner implements Runnable {
	
	public static final int SLEEP_TIME = 500;
	private MobsManager manager;
	private MovingLogic2D mobMover;
	private SpawnLogic spawnLogic;
	private boolean toKill;
	
	/**
	 * Crea uno spawner, che inserisce nel {@link MobsManager} il {@link Mob} creato,
	 * a cui viene assegnato {@link MovingLogic2D} per determianre come vuoversi,
	 * il tutto secondo l'algoritmo definito in {@link SpawnLogic}.
	 * @param manager
	 * @param mobMover
	 * @param spawnLogic
	 */
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
	 * Imposta il flag che indica se il thread � da terminare.
	 */
	public void setToKill(boolean toKill) {
		this.toKill = toKill;
	}
	
}
