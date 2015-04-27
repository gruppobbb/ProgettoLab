package model.scores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaccia per il salvataggio e il caricamento dei punteggi.
 * @author Giulia
 */
public interface IScoreManager {
	
	/**
	 * Carica gli i punteggi.
	 * @param highScores
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadScores(ArrayList<Long> highScores) throws FileNotFoundException, IOException;
	
	/**
	 * Salva i punteggi.
	 * @param highScores
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveScores(ArrayList<Long> highScores) throws FileNotFoundException, IOException;

}
