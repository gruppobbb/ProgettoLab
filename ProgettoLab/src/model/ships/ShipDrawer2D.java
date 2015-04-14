package model.ships;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;

public interface ShipDrawer2D {
	
	public void draw(Graphics g, Coordinate shipCoordinates, Dimension dimensions);

}
