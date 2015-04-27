package view2d;

import java.awt.Graphics2D;

/**
 * Interfaccia per oggetti disegnabili.
 * @author Max
 */
public interface Drawable2D {
	
	/**
	 * Disegna l'oggetto, utilizzando il graphics.
	 * @param g
	 */
	public void draw(Graphics2D g);

}
