package model.spawning;

import model.mobs.Mob;

/**
 * Logica secondo cui vengono spawnati i {@link Mob}.
 * @author Max
 */
public interface SpawnLogic {
	
	/**
	 * Spawna un array di elemento.
	 */
	public Mob[] spawnMob();

}
