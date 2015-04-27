package model.mobs;

import java.awt.Dimension;

import model.Coordinate;
import model.movement.Moveable;
import model.movement.MovingLogic2D;

/**
 * Modello di un mob che deve essere rappresentato in 2D.
 * @author Max
 * 
 */
public class Mob2D extends Mob implements Moveable {
	
	private Dimension dimension;
	private MovingLogic2D mobMover;
	
	public Mob2D(Coordinate coordinates, int shiftAmount, MovingLogic2D mobsMover) {
		super(coordinates, shiftAmount);
		this.mobMover = mobsMover;
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
		mobMover.move(this);		
	}
}
