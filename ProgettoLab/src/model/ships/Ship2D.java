package model.ships;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import view2d.Drawable2D;
import view2d.Drawer2D;

/**
 * Modello di una ship che deve essere rappresentata in 2D.
 * @author Max
 *
 */
public class Ship2D extends Ship implements Drawable2D {

	private Drawer2D shipDrawer;
	private Dimension dimension;
	
	
	public Ship2D(Coordinate coordinates, Drawer2D shipDrawer) {
		super(coordinates);
		this.shipDrawer = shipDrawer;
		setDimension(shipDrawer.getSpriteDimension());
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

	/**
	 * Disegna la ship.
	 * @param g
	 */
	public void draw(Graphics g){
		shipDrawer.draw(g, getCoordinate());
	}
	
	
	
}
