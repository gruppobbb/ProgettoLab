package view2d.drawers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import view2d.Drawer2D;

/**
 * Drawer che rappresenta l'elemento come un quadrato.
 * @author Max
 */
public class SquareDrawer implements Drawer2D {
	
	private Dimension dimension = new Dimension(50, 50);	//qui le dimensioni sono di default (non ci sono immagini!)
	
	/**
	 * @see Drawer2D
	 */
	@Override
	public void draw(Graphics g, Coordinate shipCoordinates) {
		g.setColor(Color.BLACK);
		g.fillRect((int) shipCoordinates.getX()-25, (int) shipCoordinates.getY()-25, (int) dimension.getWidth(), (int) dimension.getHeight());
	}
	
	/**
	 * @see Drawer2D
	 */
	@Override
	public Dimension getSpriteDimension() {
		return dimension;
	}

}
