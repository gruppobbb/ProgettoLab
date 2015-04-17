package model.mobs;

import model.Coordinate;
import model.collisions.Collideable;

/**
 * Modello di un generico mob. Contiene metodi e attributi comuni a tutti i mob.
 * @author Max
 *
 */
public class Mob {
	
	private Coordinate coordinate;
	private int shiftAmount;
	
	public Mob(Coordinate coordinate, int shiftAmount) {
		super();
		this.coordinate = coordinate;
		this.shiftAmount = shiftAmount;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public int getShiftAmount() {
		return shiftAmount;
	}

	public void setShiftAmount(int shiftAmount) {
		this.shiftAmount = shiftAmount;
	}
	

}