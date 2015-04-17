package model.ships;

import model.Coordinate;
import model.collisions.Collideable;

/**
 * Modello di una generica ship. Contiene metodi e attributi comuni a tutte le ship.
 * @author Max
 *
 */
public class Ship implements Collideable {
	
	private int ammo = 3;
	private Coordinate coordinate;
	public static final int SHIFT_AMOUNT = 10;
	private double collisionRay;
	
	public Ship(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
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