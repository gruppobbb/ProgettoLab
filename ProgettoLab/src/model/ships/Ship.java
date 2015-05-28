package model.ships;

import model.Coordinate;

/**
 * Modello di una generica ship. Contiene metodi e attributi comuni a tutte le ship.
 * @author Max
 */
public class Ship {

	private Coordinate coordinate;
	private double collisionRay;
	
	/**
	 * @param coordinate Coordinate iniziali della {@link Ship}
	 */
	public Ship(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	/**
	 * @param coordinate Coordinate iniziali della {@link Ship}
	 * @param collisionRay Raggio di collisione della {@link Ship}
	 */
	public Ship(Coordinate coordinate, double collisionRay) {
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