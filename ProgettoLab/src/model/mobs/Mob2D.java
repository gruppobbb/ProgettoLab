package model.mobs;

import java.awt.Dimension;
import java.awt.Graphics;

import view2d.Drawable2D;
import view2d.Drawer2D;
import model.Coordinate;

/**
 * Modello di un mob che deve essere rappresentato in 2D.
 * @author Max
 *
 */
public class Mob2D extends Mob implements Drawable2D {
	
	private Dimension dimension;
	private Drawer2D mobDrawer;
	
	public Mob2D(Coordinate coordinates, int shiftAmount, Dimension dimension, Drawer2D mobDrawer) {
		super(coordinates, shiftAmount);
		this.mobDrawer = mobDrawer;
		this.dimension = dimension;
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
	

}
