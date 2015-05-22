package model2D;

import java.awt.Dimension;

import model.Coordinate;
import model.mobs.Mob;
import model.movement.Moveable;

/**
 * Modello di un mob che deve essere rappresentato in 2D.
 * @author Max
 * 
 */
public class Mob2D extends Mob implements Moveable {
	
	private Dimension dimension;
	
	public Mob2D(Coordinate coordinates, int shiftAmount) {
		super(coordinates, (float) shiftAmount);
		setDimension(new Dimension(50,50));
	}

	public Dimension getDimension() {
		return dimension;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
		double halfHeight = (dimension.getHeight()/2);
		double halfWidth = (dimension.getWidth()/2);
		setCollisionRay(Math.sqrt(halfHeight * halfHeight + halfWidth * halfWidth));		
	}
	
	@Override
	public void move() {
		getCoordinate().setY(getCoordinate().getY() + getShiftAmount());
	}
}
