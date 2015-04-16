package model;

import java.awt.Dimension;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.mobs.Mob;
import model.mobs.Mob2D;
import model.movement.MobMover2D;
import model.movement.Mover;
import view2d.CircleMobDrawer;

public class Spawner {
	
	private MobsManager manager;
	private Mover mover = new Mover(manager);
	private Timer timer = new Timer();
	private Mob mob;
	
	public Spawner(MobsManager manager) {
		super();
		this.manager = manager;
	}
	
	
	public void newMob(){

		TimerTask spawn = new TimerTask() {
			@Override
			public void run() {
				Random rand = new Random();
				int randX = rand.nextInt((700 - 200) +1) +200;
				Mob newMob = new Mob2D(new Coordinate(randX, 20, 0),	10, new Dimension(30, 30),
						new CircleMobDrawer(), 
							new MobMover2D());
				manager.addMob(newMob);
			}
		};
		timer.scheduleAtFixedRate( spawn, 0, 1000);
		
	}
	
	


	public MobsManager getManager() {
		return manager;
	}


	public void setManager(MobsManager manager) {
		this.manager = manager;
	}
	
	
	

}
