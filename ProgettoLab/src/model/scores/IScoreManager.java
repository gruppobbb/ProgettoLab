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
	public void saveScores(ArrayList<Long> highScores, String playerName) throws FileNotFoundException, IOException;
	
	/**
	 * Carica gli i punteggi.
	 * @param highScores
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadScores(ArrayList<Long> highScores) throws FileNotFoundException, IOException;
	
	/**
	 * Ricava il nome del giocatore da file apposito.
	 * @return Il nome del giocatore
	 */
	public String getPlayerName();

}
