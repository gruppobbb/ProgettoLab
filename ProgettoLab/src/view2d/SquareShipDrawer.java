package view2d;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import model.ships.ShipDrawer2D;

public class SquareShipDrawer implements ShipDrawer2D {
	
	@Override
	public void draw(Graphics g, Coordinate shipCoordinates, Dimension dimensions) {
		
		g.fillRect(shipCoordinates.getX(), shipCoordinates.getY(), (int) dimensions.getWidth(), (int) dimensions.getHeight());
		
	}

}
