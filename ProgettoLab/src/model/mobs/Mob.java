package model.mobs;

import model.Coordinate;

/**
 * Modello di un generico mob. Contiene metodi e attributi comuni a tutti i mob.
 * @author Max
 */
public class Mob {
	
	private Coordinate coordinate;
	private float shiftAmount;
	private double collisionRay;
	
	/**
	 * @param coordinate Coordinate iniziali del {@link Mob} 
	 * @param shiftAmount Spostamento effettuato dal {@link Mob} ad ogni ciclo
	 */
	public Mob(Coordinate coordinate, float shiftAmount) {
		super();
		this.coordinate = coordinate;
		this.shiftAmount = shiftAmount;
	}
	
	/**
	 * @param coordinate Coordinate iniziali del {@link Mob} 
	 * @param shiftAmount Spostamento effettuato dal {@link Mob} ad ogni ciclo
	 * @param collisionRay Raggio di collisione del {@link Mob} 
	 */
	public Mob(Coordinate coordinate, float shiftAmount, double collisionRay) {
		super();
		this.coordinate = coordinate;
		this.shiftAmount = shiftAmount;
		this.collisionRay = collisionRay;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public float getShiftAmount() {
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