package model.spawning;

import model.MobsManager;
import model.movement.MovingLogic2D;
import view2d.Drawer2D;

public class Spawner implements Runnable {
	
	public static final int SLEEP_TIME = 1000;
	private MobsManager manager;
	private MovingLogic2D mobMover;
	private Drawer2D mobDrawer;
	private SpawnLogic spawnLogic;
	
	public Spawner(MobsManager manager, MovingLogic2D mobMover, Drawer2D mobDrawer, SpawnLogic spawnLogic) {
		super();
		this.manager = manager;
		this.mobMover = mobMover;
		this.mobDrawer = mobDrawer;
		this.spawnLogic = spawnLogic;
	}
	
	private void spawn() {
		manager.addMob(spawnLogic.spawnMob(mobMover, mobDrawer));
	}
	
	@Override
	public void run() {
		while(true) {
			spawn();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
