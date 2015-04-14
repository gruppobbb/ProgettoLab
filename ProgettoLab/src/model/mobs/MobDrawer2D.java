package model.mobs;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;

/**
 * Interfaccia che astrae sul modo in cui viene rappresentato un mob in 2D.
 * @author Max
 *
 */
public interface MobDrawer2D {
	
	/**
	 * Disegna usando i parametri passati come argomenti.
	 * @param g
	 * @param mobCoordinates
	 * @param dimensions
	 */
	public void draw(Graphics g, Coordinate mobCoordinates, Dimension dimensions);

}
