package model;

import java.awt.Graphics;

/**
 * Interfaccia per oggetti disegnabili.
 * @author Max
 *
 */
public interface Drawable2D {
	
	/**
	 * Disegna l'oggetto, utilizzando il graphics.
	 * @param g
	 */
	public void draw(Graphics g);

}
