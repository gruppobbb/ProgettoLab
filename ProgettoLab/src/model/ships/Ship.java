package model.ships;

import model.Coordinate;

/**
 * Modello di una generica ship. Contiene metodi e attributi comuni a tutte le ship.
 * @author Max
 *
 */
public class Ship {
	
	private int ammo = 3;
	private Coordinate coordinate;
	public static final int SHIFT_AMOUNT = 10;
	
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
	
}