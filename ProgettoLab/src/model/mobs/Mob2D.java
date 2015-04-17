package model.mobs;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import model.collisions.Collideable;
import model.collisions.CollisionMask;
import model.movement.Moveable;
import model.movement.Mover2D;
import view2d.Drawable2D;
import view2d.Drawer2D;

/**
 * Modello di un mob che deve essere rappresentato in 2D.
 * @author Max
 *
 */
public class Mob2D extends Mob implements Drawable2D, Moveable, Collideable {
	
	private Dimension dimension;
	private Drawer2D mobDrawer;
	private Mover2D mobMover;
	private CollisionMask collisionMask;
	
	public Mob2D(Coordinate coordinates, int shiftAmount, Dimension dimension, Drawer2D mobDrawer, Mover2D mobMover) {
		super(coordinates, shiftAmount);
		this.mobDrawer = mobDrawer;
		this.dimension = dimension;
		this.mobMover = mobMover;
		setCollisionMask(coordinates, dimension);
	}

	public Dimension getDimension() {
		return dimension;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
		setCollisionMask(getCoordinate(), dimension);
	}
	
	@Override
	public void draw(Graphics g) {
		mobDrawer.draw(g, getCoordinate(), getDimension());
	}
	
	@Override
	public void move() {
		mobMover.move(this);		
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
