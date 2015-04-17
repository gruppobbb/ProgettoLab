package model.collisions;

import model.Coordinate;

/**
 * Interfaccia per elementi che possono collidere con altri Collideable.
 * @author Max
 *
 */
public interface Collideable {
	
	public Coordinate getCoordinate();
	public double getCollisionRay();
	

}
