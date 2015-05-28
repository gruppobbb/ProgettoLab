package model.ships;

import model.Coordinate;

/**
 * Modello di una generica ship. Contiene metodi e attributi comuni a tutte le ship.
 * @author Max
 */
public class Ship {

	private Coordinate coordinate;
	public float shiftAmt;
	private double collisionRay;
	
	/**
	 * @param coordinate Coordinate iniziali della {@link Ship}
	 */
	public Ship(Coordinate coordinate) {
		this.coordinate = coordinate;
		shiftAmt = 10;  //default
	}
	
	/**
	 * @param coordinate Coordinate iniziali della {@link Ship}
	 * @param collisionRay Raggio di collisione della {@link Ship}
	 * @param shiftAmount Spostamento effettuato dalla {@link Ship} ad ogni ciclo
	 */
	public Ship(Coordinate coordinate, double collisionRay, float shiftAmount) {
		this.coordinate = coordinate;
		this.collisionRay = collisionRay;
		this.shiftAmt = shiftAmount;
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

	public float getShiftAmt() {
		return shiftAmt;
	}

	public void setShiftAmt(int shiftAmt) {
		this.shiftAmt = shiftAmt;
	}
	
	
}