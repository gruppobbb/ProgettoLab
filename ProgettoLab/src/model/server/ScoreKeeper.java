package model.server;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe che gestisce gli High Score. E' un Singleton.
 * @author Giulia
 *
 */

public class ScoreKeeper {
	
	private static ScoreKeeper scoreKeeper;
	private static ArrayList<Integer> highScores;
	
	private ScoreKeeper() {
		highScores = new ArrayList<Integer>(10);
//		CODICE DI TEST
		highScores.add(7843);
		highScores.add(75);
		highScores.add(26);
		highScores.add(744);
		highScores.add(85764);
		highScores.add(876);
		highScores.add(4098);
		highScores.add(387);
		highScores.add(65);
		highScores.add(504);
//		FINE CODICE DI TEST
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
	
	public ArrayList<Integer> getHighScores(){
		Collections.sort(highScores);
		Collections.reverse(highScores);
		if (highScores.size() > 10) {
			highScores.subList(10, highScores.size()).clear();
		}
		return highScores;
	}
	
	/**
	 * Metodo per aggiungere un nuovo punteggio, viene chiamato a fine partita.
	 * @param score Nuovo punteggio
	 */
	public void addScore(int score){
		highScores.add(score);
	}
	
}
