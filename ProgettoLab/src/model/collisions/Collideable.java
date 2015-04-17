package model.collisions;

import model.Coordinate;

/**
 * Interfaccia per elementi che possono collidere con altri Collideable.
 * @author Max
 *
 */
public interface Collideable {
	
	/**
	 * Ritorna la collision mask del Collideable.
	 * @return
	 */
	public CollisionMask getCollisionMask();
	

}
