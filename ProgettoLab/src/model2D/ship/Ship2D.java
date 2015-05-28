package model2D.ship;

import java.awt.Dimension;

import model.Coordinate;
import model.ships.Ship;

/**
 * Modello di una ship che deve essere rappresentata in 2D.
 * @author Max
 */
public class Ship2D extends Ship{

	private int shiftAmount;
	public static final double COLLISION_RAY = 30;
	public static final int DEFAULT_SHIFT_AMOUNT = 10;
	
	/**
	 * Crea una Ship nelle {@link Coordinate} indicate. Lo shiftAmount è impostato al valore di default, ma può essere modificato tramite getShiftAmount().
	 * @param coordinates Coordinate iniziali
	 */
	public Ship2D(Coordinate coordinates) {
		super(coordinates);
		setCollisionRay(COLLISION_RAY);
		this.shiftAmount = DEFAULT_SHIFT_AMOUNT;
	}
	
	/**
	 * Restituisce lo shift amount corrente della ship.
	 * @return shift amount
	 */
	public int getShiftAmount() {
		return shiftAmount;
	}

	/**
	 * Imposta lo shift amount della ship.
	 * @param shiftAmount
	 */
	public void setShiftAmount(int shiftAmount) {
		this.shiftAmount = shiftAmount;
	}	
	
}
