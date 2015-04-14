package view2d;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;

/**
 * Drawer che rappresenta la ship come un quadrato.
 * @author Max
 *
 */
public class SquareShipDrawer implements Drawer2D {
	
	@Override
	public void draw(Graphics g, Coordinate shipCoordinates, Dimension dimensions) {
		
		g.fillRect(shipCoordinates.getX(), shipCoordinates.getY(), (int) dimensions.getWidth(), (int) dimensions.getHeight());
		
	}

}
