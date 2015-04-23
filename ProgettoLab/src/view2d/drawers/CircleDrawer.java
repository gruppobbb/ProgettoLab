package view2d.drawers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import view2d.Drawer2D;

/**
 * Drawer che rappresenta la ship come un quadrato.
 * @author Max
 *
 */
public class CircleDrawer implements Drawer2D {
	
	private Dimension dimension = new Dimension(50, 50);	//qui le dimensioni sono di default (non ci sono immagini!)
	
	@Override
	public void draw(Graphics g, Coordinate mobCoordinates) {
		
		g.setColor(Color.RED);
		g.fillOval(mobCoordinates.getX()-25, mobCoordinates.getY()-25, (int) dimension.getWidth(), (int) dimension.getHeight());
		
	}
	
	@Override
	public Dimension getSpriteDimension() {
		return dimension;
	}

}