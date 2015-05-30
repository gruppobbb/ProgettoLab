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
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public long getScore() {
		return score;
	}
	
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
