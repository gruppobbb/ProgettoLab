package model.mobs;

import model.Coordinate;
import model.collisions.Collideable;

/**
 * Modello di un generico mob. Contiene metodi e attributi comuni a tutti i mob.
 * @author Max
 *
 */
public class Mob implements Collideable {
	
	private Coordinate coordinate;
	private int shiftAmount;
	private double collisionRay;
	
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

	public double getCollisionRay() {
		return collisionRay;
	}

	public void setCollisionRay(double collisionRay) {
		this.collisionRay = collisionRay;
	}
	
	
	@Override
	public String toString() {
		return "Mob at "+coordinate;
	}
}