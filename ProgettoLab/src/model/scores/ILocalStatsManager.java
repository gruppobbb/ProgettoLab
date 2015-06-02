package model.scores;

/**
 * Interfaccia per la gestione delle statistiche locali (nome giocatore, miglior punteggio personale)
 * su file specificato nel costruttore.
 * @author Giulia
 *
 */
public interface ILocalStatsManager {
	
	/**
	 * Setta il miglior punteggio personale.
	 * @param score Miglior punteggio personale
	 */
	public void setPersonalBest(long score);
	/**
	 * Ritorna il miglior punteggio personale.
	 * @return Miglior punteggio personale
	 */
	public long getPersonalBest();
	/**
	 * Setta il nome del giocatore.
	 * @param playerName Nome del giocatore
	 */
	public void setPlayerName(String playerName);
	/**
	 * Ritorna il nome del giocatore.
	 * @return Nome del giocatore
	 */
	public String getPlayerName();

}
