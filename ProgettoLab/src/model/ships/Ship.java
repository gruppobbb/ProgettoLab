package model.ships;

import model.Coordinate;

/**
 * Modello di una generica ship. Contiene metodi e attributi comuni a tutte le ship.
 * @author Max
 */
public class Ship {

	private Coordinate coordinate;
	public float shiftAmt = 10;
	private double collisionRay;
	
	public Ship(Coordinate coordinate) {
		this.coordinate = coordinate;
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