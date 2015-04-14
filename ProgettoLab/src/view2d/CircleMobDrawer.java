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
	
	@Override
	public void draw(Graphics g, Coordinate mobCoordinates, Dimension dimensions) {
		
		g.setColor(Color.red);
		g.fillOval(mobCoordinates.getX(), mobCoordinates.getY(), (int) dimensions.getWidth(), (int) dimensions.getHeight());
		
	}

}
