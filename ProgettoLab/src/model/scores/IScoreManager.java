package model.scores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaccia per il salvataggio dei punteggi.
 * @author Giulia
 */
public interface IScoreManager {
	
	/**
	 * Salva i punteggi.
	 * @param highScores
	 * @param playerName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveScores(ArrayList<ScoreEntry> highScores, String playerName) throws FileNotFoundException, IOException;
	
	/**
	 * Carica gli i punteggi.
	 * @param highScores
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadScores(ArrayList<ScoreEntry> highScores) throws FileNotFoundException, IOException;

}
