package model.ships;

import java.awt.Dimension;
import java.awt.Graphics;

import view2d.Drawable2D;
import view2d.Drawer2D;
import model.Coordinate;
import model.collisions.Collideable;
import model.collisions.CollisionMask;
import model.movement.Moveable;

/**
 * Modello di una ship che deve essere rappresentata in 2D.
 * @author Max
 *
 */
public class Ship2D extends Ship implements Drawable2D, Collideable {

	private Drawer2D shipDrawer;
	private Dimension dimension;
	private CollisionMask collisionMask;
	
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
		setCollisionMask(getCoordinate(), dimension);
	}

	/**
	 * Disegna la ship.
	 * @param g
	 */
	public void draw(Graphics g){
		shipDrawer.draw(g, getCoordinate());
	}
	
	@Override
	public CollisionMask getCollisionMask() {
		return collisionMask;
	}

	private void setCollisionMask(Coordinate coordinates, Dimension dimension) {
		double halfHeight = (dimension.getHeight()/2);
		double halfWidth = (dimension.getWidth()/2);
		double collisionRay = Math.sqrt(halfHeight * halfHeight + halfWidth * halfWidth);
		this.collisionMask = new CollisionMask(coordinates, collisionRay);
	}	
	
}
