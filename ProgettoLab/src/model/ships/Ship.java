package model.ships;

import model.Coordinate;

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