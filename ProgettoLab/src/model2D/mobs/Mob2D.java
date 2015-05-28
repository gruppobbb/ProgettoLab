package model2D.mobs;

import model.Coordinate;
import model.mobs.Mob;
import model.movement.Moveable;

/**
 * Modello di un mob che deve essere rappresentato in 2D.
 * @author Max
 * 
 */
public class Mob2D extends Mob implements Moveable {
		
	public static final double COLLISION_RAY = 25;
	
	/**
	 * @see Mob
	 * @param coordinates
	 * @param shiftAmount
	 */
	public Mob2D(Coordinate coordinates, int shiftAmount) {
		super(coordinates, (float) shiftAmount);
		setCollisionRay(COLLISION_RAY);
	}
	
	/**
	 * @see Moveable
	 */
	@Override
	public void move() {
		getCoordinate().setY(getCoordinate().getY() + getShiftAmount());
	}
}
