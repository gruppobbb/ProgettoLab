package model;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.mobs.Mob;
import model.mobs.Mob2D;
import model.movement.Mover2D;
import view2d.CircleMobDrawer;

public class Spawner {
	
	private MobsManager manager;
	private Mover2D mobMover;
	private Timer timer = new Timer();
	
	public Spawner(MobsManager manager, Mover2D mobMover) {
		super();
		this.manager = manager;
		this.mobMover = mobMover;
	}
	
	
	public void start(){

		TimerTask spawn = new TimerTask() {
			@Override
			public void run() {
				manager.addMob(spawn());
				
				//DEBUG CODE
				System.out.println("(" + manager.getMobsList().size() + " mobs are currently spawned)");
				//
			}

			
		};
		timer.scheduleAtFixedRate( spawn, 0, 1000);
		
	}
	
	protected Mob spawn() {
		Random rand = new Random();
		int randX = rand.nextInt((700 - 200) +1) +200;
		Mob newMob = new Mob2D(new Coordinate(randX, 20, 0),	10, 
				new CircleMobDrawer(), 
					mobMover);
		return newMob;
	}
	
	public MobsManager getManager() {
		return manager;
	}


	public void setManager(MobsManager manager) {
		this.manager = manager;
	}
	
	
	

}
