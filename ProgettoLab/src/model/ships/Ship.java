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

	/**
	 * Ritorna le coordinate attuali della ship.
	 * @return coordinate della ship
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * Imposta le coordinate della ship.
	 * @param coordinate della ship
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * Restituisce il raggio di collisione della ship.
	 * @return raggio di collisione della ship
	 */
	public double getCollisionRay() {
		return collisionRay;
	}

	/**
	 * Imposta il collision ray della ship.
	 * @param collisionRay Raggio di collisione della ship
	 */
	public void setCollisionRay(double collisionRay) {
		this.collisionRay = collisionRay;
	}	
	
}