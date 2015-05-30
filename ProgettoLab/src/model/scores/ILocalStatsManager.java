package model.scores;

/**
 * Interfaccia per la gestione delle statistiche locali (nome giocatore, miglior punteggio personale)
 * su file specificato nel costruttore.
 * @author Giulia
 *
 */
public interface ILocalStatsManager {
	
	public void setPersonalBest(long score);
	public long getPersonalBest();
	public void setPlayerName(String playerName);
	public String getPlayerName();

}
