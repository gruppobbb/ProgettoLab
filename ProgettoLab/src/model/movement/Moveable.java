package model.movement;

import model.GameEngine;

/**
 * Interfaccia per elementi che possono essere mossi da un {@link GameEngine}
 * @author Max
 */
public interface Moveable {
	
	/**
	 * Muove l'elemento.
	 */
	public void move();

}