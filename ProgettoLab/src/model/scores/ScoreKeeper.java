package model.scores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe che gestisce gli High Score. E' un singleton.
 * @author Giulia
 */
public class ScoreKeeper {
	
	private static ScoreKeeper scoreKeeper;
	private static ArrayList<Long> highScores;
	public static final int MAX_SCORES = 10;
	private IScoreManager scoreManager;
	private String playerName;
	
	private ScoreKeeper() {
		playerName = "Player";
		highScores = new ArrayList<Long>(MAX_SCORES);
		setScoreManager(new LocalScoreManager());
		updateList();
	}
	
	/**
	 * Restituisce l'istanza dello ScoreManager.
	 * @return
	 */
	public static ScoreKeeper getInstance(){
		if(scoreKeeper == null){
			scoreKeeper = new ScoreKeeper();
		}
		return scoreKeeper;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Metodo che restituisce i primi 10 punteggi ordinati numericamente.
	 * @return Lista dei 10 punteggi piu' alti
	 */
	public ArrayList<Long> getHighScores(){
		return highScores;
	}
	
	public void setScoreManager(IScoreManager scoreManager) {
		this.scoreManager = scoreManager;
	}
	
	
	/**
	 * Aggiorna la lista dei punteggi.
	 */
	public void updateList(){
		try {
			highScores.clear();
			scoreManager.loadScores(highScores);
			playerName = scoreManager.getPlayerName();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo per aggiungere un nuovo punteggio, viene chiamato a fine partita.
	 * @param score Nuovo punteggio
	 */
	public void addScore(long score){
		highScores.add(score);
		try {
			trimScoreList();
			scoreManager.saveScores(highScores, playerName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Riduce la lista dei punteggi a 10 elementi ordinati per valore.
	 */
	public void trimScoreList(){
		Collections.sort(highScores);
		Collections.reverse(highScores);
		if (highScores.size() > MAX_SCORES) {
			highScores.subList(MAX_SCORES, highScores.size()).clear();
		}
	}
	
}