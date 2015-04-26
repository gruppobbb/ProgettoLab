package model.scores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaccia per il salvataggio e il caricamento dei punteggi.
 * @author Giulia
 */
public interface IScoreManager {
	

	public void loadScores(ArrayList<Long> highScores) throws FileNotFoundException, IOException;
	
	public void saveScores(ArrayList<Long> highScores) throws FileNotFoundException, IOException;

}
