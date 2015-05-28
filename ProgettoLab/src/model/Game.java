package model;

/**
 * Interfaccia per i metodi di avvio/pausa/fine del gioco.
 * @author Max
 */
public interface Game {
	/**
	 * Inizia una nuova partita.
	 */
	public void start();
	/**
	 * Mette in pausa la partita in corso.
	 */
	public void pause();
	/**
	 * Termina la partita.
	 */
	public void gameOver();
}
