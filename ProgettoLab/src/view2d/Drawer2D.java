package view2d;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;

/**
 * Interfaccia che astrae sul modo in cui viene rappresentato un elemento in 2D.
 * @author Max
 */
public interface Drawer2D {
	
	/**
	 * Disegna usando i parametri passati come argomenti.
	 * @param g
	 * @param coordinates
	 */
	public void draw(Graphics g, Coordinate coordinates);
	
	/**
	 * Ritorna le dimensioni attuali dello sprite.
	 * @return
	 */
	public Dimension getSpriteDimension();

}
