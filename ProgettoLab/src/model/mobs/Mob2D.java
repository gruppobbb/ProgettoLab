package model.mobs;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import model.movement.Moveable;
import model.movement.Mover2D;
import view2d.Drawable2D;
import view2d.Drawer2D;

/**
 * Modello di un mob che deve essere rappresentato in 2D.
 * @author Max
 *
 */
public class Mob2D extends Mob implements Drawable2D, Moveable {
	
	private Dimension dimension;
	private Drawer2D mobDrawer;
	private Mover2D mobMover;
	
	public Mob2D(Coordinate coordinates, int shiftAmount, Dimension dimension, Drawer2D mobDrawer, Mover2D mobMover) {
		super(coordinates, shiftAmount);
		this.mobDrawer = mobDrawer;
		this.dimension = dimension;
		this.mobMover = mobMover;
	}
	
	public Dimension getDimension() {
		return dimension;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	@Override
	public void draw(Graphics g) {
		mobDrawer.draw(g, getCoordinate(), getDimension());
	}
	
	@Override
	public void move() {
		mobMover.move(this);		
	}
	

}
