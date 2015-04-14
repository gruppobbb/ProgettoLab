package model.ships;

import java.awt.Dimension;
import java.awt.Graphics;

import view2d.Drawable2D;
import view2d.Drawer2D;
import model.Coordinate;
import model.movement.Moveable;

/**
 * Modello di una ship che deve essere rappresentata in 2D.
 * @author Max
 *
 */
public class Ship2D extends Ship implements Drawable2D {

	private Drawer2D shipDrawer;
	private Dimension dimension;
	
	public Ship2D(Coordinate coordinates, Dimension dimensions, Drawer2D shipDrawer) {
		super(coordinates);
		this.shipDrawer = shipDrawer;
		this.dimension = dimensions;			
	}
	
	public Dimension getDimension() {
		return dimension;
	}

	private void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * Disegna la ship.
	 * @param g
	 */
	public void draw(Graphics g){
		shipDrawer.draw(g, getCoordinate(), getDimension());
	}

	
}
