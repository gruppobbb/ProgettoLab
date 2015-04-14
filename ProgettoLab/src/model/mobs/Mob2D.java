package model.mobs;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import model.Drawable2D;
import model.Drawer2D;

/**
 * Modello di un mob che deve essere rappresentato in 2D.
 * @author Max
 *
 */
public class Mob2D implements Drawable2D {
	
	private Mob mob;
	private Dimension dimension;
	private Drawer2D mobDrawer;
	
	public Mob2D(Coordinate coordinates, int shiftAmount, Drawer2D mobDrawer) {
		super();
		this.mobDrawer = mobDrawer;
		this.mob = new Mob(coordinates, shiftAmount);
		
		mob.setShiftAmount(shiftAmount);
	}

	public Coordinate getCoordinate() {
		return mob.getCoordinate();
	}

	public void setCoordinate(Coordinate coordinate) {
		mob.setCoordinate(coordinate);
	}

	public int getShiftAmount() {
		return mob.getShiftAmount();
	}

	public void setShiftAmount(int shiftAmount) {
		mob.setShiftAmount(shiftAmount);
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
