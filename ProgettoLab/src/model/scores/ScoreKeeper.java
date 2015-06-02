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
	public static final int MAX_SCORES = 10;
	private static ArrayList<ScoreEntry> highScores = new ArrayList<ScoreEntry>(MAX_SCORES);
	private IScoreManager scoreManager;
	private ILocalStatsManager localStats;
	
	private ScoreKeeper() {

		scoreManager = ManagerKeeper.getInstance().getScoreManager();
		localStats = ManagerKeeper.getInstance().getLocalStats();
		
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
	
	/**
	 * Metodo che restituisce i primi 10 punteggi ordinati numericamente.
	 * @return Lista dei 10 punteggi piu' alti
	 */
	public ArrayList<ScoreEntry> getHighScores(){
		trimScoreList();
		return highScores;
	}

	/**
 * Aggiorna la lista dei punteggi. Qualora non fossero presente uno scoreManager, 
 * si lavora solo in locale, con una lista di punteggi temporanea
	 */
	public void updateList(){
		if (scoreManager != null) {
			try {
				highScores.clear();
				scoreManager.loadScores(highScores);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else
			highScores.clear();
	}
	
	/**
	 * Metodo per aggiungere un nuovo punteggio, viene chiamato a fine partita.
	 * Qualora non fossero presenti dei gestori di LocalStats e ScoreManager, 
	 * si lavora solo in locale, con una lista di punteggi temporanea
	 * @param score Nuovo punteggio
	 */
	public void addScore(long score){
		if (localStats != null && scoreManager != null) {
			if (score > localStats.getPersonalBest()) {
				localStats.setPersonalBest(score);
			}
			highScores.add(new ScoreEntry(localStats.getPlayerName(), score));
			try {
				trimScoreList();
				scoreManager.saveScores(highScores, localStats.getPlayerName());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			highScores.add(new ScoreEntry("Player", score));
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
	
	/**
	 * Ritorna il nome del giocatore, settandone uno di default qualora non siano presenti i manager
	 * @return
	 */
	
	public String getPlayerName(){
		if(localStats != null){
			return localStats.getPlayerName();
		}
		else
			return "Player";	
	}
	
	/**
	 * Ritorna il punteggio migliore del giocatore
	 * @return
	 */
	public long getPersonalBest(){
		if(localStats != null){
			return localStats.getPersonalBest();
		}else{
			Collections.sort(highScores);
			Collections.reverse(highScores);
			return highScores.get(0).getScore();
		}
	}
	
}