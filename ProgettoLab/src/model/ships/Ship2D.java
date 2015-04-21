package model.ships;

import java.awt.Dimension;

import model.Coordinate;

/**
 * Modello di una ship che deve essere rappresentata in 2D.
 * @author Max
 *
 */
public class Ship2D extends Ship{

	private Dimension dimension;
	
	public Ship2D(Coordinate coordinates) {
		super(coordinates);
		setDimension(new Dimension(50,50));
	}
	
	public Dimension getDimension() {
		return dimension;
	}

	private void setDimension(Dimension dimension) {
		this.dimension = dimension;
		double halfHeight = (dimension.getHeight()/2);
		double halfWidth = (dimension.getWidth()/2);
		setCollisionRay(Math.sqrt(halfHeight * halfHeight + halfWidth * halfWidth));		
	}

}
