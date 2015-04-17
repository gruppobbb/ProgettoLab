package model.collisions;

import model.Coordinate;

/**
 * Struttura dati che contiene informazioni sulla geometria del componente per il controllo collisioni.
 * @author Max
 *
 */
public class CollisionMask {
	
	private Coordinate coordinate;
	private double collisionRay;
	
	public CollisionMask(Coordinate coordinate, double collisionRay) {
		this.coordinate = coordinate;
		this.collisionRay = collisionRay;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public double getCollisionRay() {
		return collisionRay;
	}

	public void setCollisionRay(double collisionRay) {
		this.collisionRay = collisionRay;
	}
	
	
}
