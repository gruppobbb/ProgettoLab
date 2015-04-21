package model.spawning;

import model.mobs.Mob;
import model.movement.MovingLogic2D;
import view2d.Drawer2D;

/**
 * Logica secondo cui vengono spawnati gli elementi.
 * @author Max
 *
 */
public interface SpawnLogic {
	
	/**
	 * Spawna un elemento.
	 */
	public Mob spawnMob(MovingLogic2D mobMover, Drawer2D mobDrawer);

}
