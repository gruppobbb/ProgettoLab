package model.spawning;

import model.mobs.Mob;

/**
 * Logica secondo cui vengono spawnati i {@link Mob}.
 * @author Max
 */
public interface SpawnLogic {
	
	/**
	 * Spawna un insieme di {@link Mob} e restituisce un vettore di reference ad essi.
	 */
	public Mob[] spawnMob();

}
