package model.spawning;

import java.util.Random;

import assetsPc.Assets;
import model.Coordinate;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.movement.MovingLogic2D;

/**
 * Logica di spawning 2D basata sul concetto di corsia.
 * @author Max
 * @author Jan
 */
public class SimpleLanes2DSpawnerM implements SpawnLogic {
	
	private Random rand;
	private Mob[] mobs;
	private int randX;
	private int N;
	private int mobWidth;
	private int laneWidth;
	
	/**
	 * Spawner che crea un {@link Mob} all'interno di width, un una corsia casuale.
	 * @param width
	 */
	public SimpleLanes2DSpawnerM(int width) {
		rand = new Random();
		mobWidth = Assets.getLoader().getSprite(Assets.SPRITE_MOB).getWidth();
		N = (int)(width/mobWidth);
		laneWidth = width / N;	// N è già intero
	}
	
	@Override
	public Mob[] spawnMob(MovingLogic2D mobMover) {
		
		mobs = new Mob[rand.nextInt(N-1) + 1];
		for (int i = 0; i < mobs.length; i++) {
			randX =(int)(laneWidth/2  + (rand.nextInt(N) * laneWidth)) ;
			mobs[i] = new Mob2D(new Coordinate(randX, -200, 0),	7, mobMover);
		}
				
		return mobs;
	}
}
