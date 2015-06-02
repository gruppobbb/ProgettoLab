package model.scores;

/**
 * Entry singola della lista dei punteggi: comprende di nome giocatore e rispettivo punteggio.
 * @author Giulia
 *
 */
public class ScoreEntry implements Comparable<ScoreEntry>{
	
	private String playerName;
	private long score;
	
	public ScoreEntry() {
	}
	
	/**
	 * @param playerName Nome del giocatore
	 * @param score Punteggio del giocatore
	 */
	public ScoreEntry(String playerName, long score) {
		this.playerName = playerName;
		this.score = score;
	}
	
	/**
	 * Restituisce il nome del giocatore.
	 * @return Nome del giocatore
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Imposta il nome del giocatore.
	 * @param playerName Nome del giocatore
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Restituisce il punteggio.
	 * @return Punteggio
	 */
	public long getScore() {
		return score;
	}
	
	/**
	 * Imposta il punteggio.
	 * @param score Punteggio
	 */
	public void setScore(long score) {
		this.score = score;
	}

	@Override
	public int compareTo(ScoreEntry entry) {
		if(score < entry.getScore())
			return -1;
		else if(score > entry.getScore())
			return 1;
		return 0;
	}

}
