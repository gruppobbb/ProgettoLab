package model.mobs;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;

/**
 * Interfaccia che astrae sul modo in cui viene rappresentata una ship in 2D.
 * @author Max
 *
 */
public interface ShipDrawer2D {
	
	/**
	 * Disegna usando i parametri passati come argomenti.
	 * @param g
	 * @param shipCoordinates
	 * @param dimensions
	 */
	public void draw(Graphics g, Coordinate shipCoordinates, Dimension dimensions);

}
