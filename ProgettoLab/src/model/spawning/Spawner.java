package model.spawning;

import java.util.Random;

import model.Coordinate;
import model.MobsManager;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.movement.MovingLogic2D;
import view2d.Drawer2D;

public class Spawner implements Runnable {
	
	public static final int SLEEP_TIME = 1000;
	private MobsManager manager;
	private MovingLogic2D mobMover;
	private Drawer2D mobDrawer;
	
	public Spawner(MobsManager manager, MovingLogic2D mobMover, Drawer2D mobDrawer) {
		super();
		this.manager = manager;
		this.mobMover = mobMover;
		this.mobDrawer = mobDrawer;
	}
	
	private void spawn() {
		Random rand = new Random();
		int randX = rand.nextInt((700 - 200) +1) +200;
		Mob newMob = new Mob2D(new Coordinate(randX, 20, 0), 10, mobDrawer, mobMover);
		manager.addMob(newMob);
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
