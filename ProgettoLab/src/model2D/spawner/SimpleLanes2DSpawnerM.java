package model2D.spawner;

import java.util.Random;

import assetsPc.Assets;
import model.Coordinate;
import model.mobs.Mob;
import model.spawning.SpawnLogic;
import model2D.mobs.Mob2D;

/**
 * Logica di spawning 2D basata sul concetto di corsia, versione altrenativa che permette lo spawning di più {@link Mob} contemporaneamente.
 * @author Max
 */
public class SimpleLanes2DSpawnerM implements SpawnLogic {
	
	private Random rand;
	private Mob[] mobs;
	private int randX;
	private int N;
	private int mobWidth;
	private int laneWidth;
	
	/**
	 * @param width Larghezza dell'area di gioco
	 */
	public SimpleLanes2DSpawnerM(int width) {
		rand = new Random();
		mobWidth = Assets.getLoader().getSprite(Assets.SPRITE_MOB).getWidth();
		N = (int)(width/mobWidth);
		laneWidth = width / N;	// N è già intero
	}
	
	/**
	 * @see SpawnLogic
	 */
	@Override
	public Mob[] spawnMob() {		
		mobs = new Mob[rand.nextInt(N-2) + 1];
		for (int i = 0; i < mobs.length; i++) {
			randX =(int)(laneWidth/2  + (rand.nextInt(N) * laneWidth)) ;
			mobs[i] = new Mob2D(new Coordinate(randX, -200, 0),	7);
		}				
		return mobs;
	}
}
