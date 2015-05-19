package model2D;

import java.util.Random;

import model.Coordinate;
import model.mobs.Mob;
import model.spawning.SpawnLogic;

/**
 * Logica di spawning 2D elementare, basata su variabili casuali uniformi.
 * @author Max
 */
public class SimpleRandom2DSpawnLogic implements SpawnLogic {
	
	@Override
	public Mob[] spawnMob(MovingLogic2D mobMover) {
		Mob[] mobs = new Mob[1];
		Random rand = new Random();
		int randX = rand.nextInt((700 - 200) +1) +200;
		mobs[0] = new Mob2D(new Coordinate(randX, 20, 0), 10, mobMover);
		return mobs;
	}
}
