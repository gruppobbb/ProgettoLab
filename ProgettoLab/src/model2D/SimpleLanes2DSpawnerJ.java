package model2D;

import java.util.Random;

import assetsPc.Assets;
import model.Coordinate;
import model.mobs.Mob;
import model.spawning.SpawnLogic;

/**
 * Logica di spawning 2D basata sul concetto di corsia.
 * @author Max
 * @author Jan
 */
public class SimpleLanes2DSpawnerJ implements SpawnLogic {
	
	private int width;
	private int spawnArea;
	private Random rand;
	private Mob[] mobs;
	private int randX;
	private int N;
	private int mobWidth;
	
	
	/**
	 * Spawner che crea un {@link Mob} all'interno di width, un una corsia casuale.
	 * @param width
	 */
	public SimpleLanes2DSpawnerJ(int width) {
		this.width = width;
		rand = new Random();
		mobWidth = Assets.getLoader().getSprite(Assets.SPRITE_MOB).getWidth();
		N = (width/mobWidth);
		mobs = new Mob[1];
	}
	
	@Override
	public Mob[] spawnMob() {
		
		spawnArea = N*mobWidth;

		randX =(int)((width - spawnArea) / 2 + mobWidth / 2 + rand.nextInt(N) * mobWidth) ;
		
		mobs[0] = new Mob2D(new Coordinate(randX, -200, 0),	7);
		
		return mobs;
	}
}
