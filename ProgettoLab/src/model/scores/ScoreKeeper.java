package model.scores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe che gestisce gli High Score. E' un singleton.
 * @author Giulia
 */
public class ScoreKeeper {
	
	private static ScoreKeeper scoreKeeper;
	private static ArrayList<Long> highScores;
	public static final int MAX_SCORES = 10;
	private IScoreManager scoreManager;
	
	private ScoreKeeper(IScoreManager scoreManager) {
		this.scoreManager = scoreManager;
		highScores = new ArrayList<Long>(MAX_SCORES);
		updateList();
	}
	
	public static ScoreKeeper getScoreKeeper(){
		if(scoreKeeper == null){
			scoreKeeper = new ScoreKeeper(new LocalScoreManager());
		}
		return scoreKeeper;
	}
	
	/**
	 * Metodo che restituisce i primi 10 punteggi ordinati numericamente.
	 * @return Lista dei 10 punteggi piu' alti
	 */
	public ArrayList<Long> getHighScores(){
		return highScores;
	}
	
	/**
	 * Metodo per aggiungere un nuovo punteggio, viene chiamato a fine partita.
	 * @param score Nuovo punteggio
	 */
	public void addScore(long score){
		updateList();
		highScores.add(score);
		try {
			scoreManager.saveScores(highScores);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Aggiorna la lista dei punteggi.
	 */
	public void updateList(){
		try {
			scoreManager.loadScores(highScores);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}