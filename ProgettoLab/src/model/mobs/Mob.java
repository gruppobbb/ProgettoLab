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

	/**
	 * Restituisce le coordinate attuali del mob.
	 * @return {@link Coordinate} del mob
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * Imposta le coordinate del mob.
	 * @param coordinate Coordinate del mob
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * Restituisce lo shift amount del mob.
	 * @return shift amount
	 */
	public float getShiftAmount() {
		return shiftAmount;
	}

	/**
	 * Imposta lo shift amount del mob.
	 * @param shift amount
	 */
	public void setShiftAmount(int shiftAmount) {
		this.shiftAmount = shiftAmount;
	}

	/**
	 * Restituisce l'attuale raggio di collisione del mob.
	 * @return raggio di collisione
	 */
	public double getCollisionRay() {
		return collisionRay;
	}

	/**
	 * Imposta il raggio di collisione del mob.
	 * @param collisionRay Raggio di collisione
	 */
	public void setCollisionRay(double collisionRay) {
		this.collisionRay = collisionRay;
	}
	
}