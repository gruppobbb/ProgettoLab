package view2d;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;

/**
 * Drawer che rappresenta la ship come un quadrato.
 * @author Max
 *
 */
public class CircleMobDrawer implements Drawer2D {
	
	private Dimension dimension = new Dimension(50, 50);	//qui le dimensioni sono di default (non ci sono immagini!)
	
	@Override
	public void draw(Graphics g, Coordinate mobCoordinates) {
		
		g.setColor(Color.red);
		g.fillOval(mobCoordinates.getX(), mobCoordinates.getY(), (int) dimension.getWidth(), (int) dimension.getHeight());
		
	}
	
	@Override
	public Dimension getSpriteDimension() {
		return dimension;
	}

}
