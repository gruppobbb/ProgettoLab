package model.spawning;

import model.mobs.Mob;
import model.movement.MovingLogic2D;

/**
 * Logica secondo cui vengono spawnati i {@link Mob}.
 * @author Max
 */
public interface SpawnLogic {
	
	/**
	 * Spawna un elemento.
	 */
	public Mob spawnMob(MovingLogic2D mobMover);

}
