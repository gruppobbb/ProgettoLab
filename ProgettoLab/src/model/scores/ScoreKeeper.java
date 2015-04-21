package model.scores;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe che gestisce gli High Score. E' un Singleton.
 * @author Giulia
 *
 */

public class ScoreKeeper {
	
	private static ScoreKeeper scoreKeeper;
	private static ArrayList<Long> highScores;
	public static final int MAX_SCORES = 10;
	
	private ScoreKeeper() {
		highScores = new ArrayList<Long>(MAX_SCORES);
		for (int i = 0; i < MAX_SCORES; i++) {
			highScores.add(0l);
		}
		
	}
	/**
	 * Per recuperare il Singleton.
	 * @return Il singleton yo
	 */
	public static ScoreKeeper getScoreKeeper(){
		if(scoreKeeper == null){
			scoreKeeper = new ScoreKeeper();
		}
		return scoreKeeper;
	}
	
	/**
	 * Metodo che restituisce i primi 10 punteggi ordinati numericamente.
	 * @return Lista dei 10 punteggi piu' alti
	 */
	
	public ArrayList<Long> getHighScores(){
		Collections.sort(highScores);
		Collections.reverse(highScores);
		if (highScores.size() > MAX_SCORES) {
			highScores.subList(MAX_SCORES, highScores.size()).clear();
		}
		return highScores;
	}
	
	/**
	 * Metodo per aggiungere un nuovo punteggio, viene chiamato a fine partita.
	 * @param score Nuovo punteggio
	 */
	public void addScore(long score){
		highScores.add(score);
	}
	
}