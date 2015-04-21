package model.spawning;

import java.util.Random;

import model.Coordinate;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.movement.MovingLogic2D;
import view2d.Drawer2D;

public class SimpleRandom2DSpawnLogic implements SpawnLogic {
	
	@Override
	public Mob spawnMob(MovingLogic2D mobMover, Drawer2D mobDrawer) {
		Random rand = new Random();
		int randX = rand.nextInt((700 - 200) +1) +200;
		Mob newMob = new Mob2D(new Coordinate(randX, 20, 0), 10, mobDrawer, mobMover);
		return newMob;
	}
	

}
