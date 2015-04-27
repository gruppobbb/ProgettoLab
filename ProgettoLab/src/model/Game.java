package model;

/**
 * Interfaccia per i metodi di avvio/pausa/fine del gioco.
 * @author Max
 */
public interface Game {
	public void start();
	public void pause();
	public void gameOver();
}
