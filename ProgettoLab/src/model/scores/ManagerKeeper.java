package model.scores;

/**
 * Componente singleton che contiene le istanze di {@link IScoreManager} e {@link ILocalStatsManager} da utilizzare.
 * @author Giulia
 */
public class ManagerKeeper {
	
	private static ManagerKeeper managerKeeper;
	
	private IScoreManager scoreManager;
	private ILocalStatsManager localStats;
	
	private ManagerKeeper(){
	}
	
	/**
	 * Restituisce l'istanza corrente di ManagerKeeper.
	 * @return Istanza corrente
	 */
	public static ManagerKeeper getInstance(){
		if(managerKeeper == null){
			managerKeeper = new ManagerKeeper();
		}
		return managerKeeper;
	}
	
	/**
	 * Imposta l'istanza di {@link ILocalStatsManager}.
	 * @param localStats Istanza del manager per i punteggi locali
	 */
	public void setLocalStats(ILocalStatsManager localStats) {
		this.localStats = localStats;
	}
	
	/**
	 * Imposta l'istanza di @link {@link IScoreManager}.
	 * @param scoreManager Istanza del manager per i punteggi
	 */
	public void setScoreManager(IScoreManager scoreManager) {
		this.scoreManager = scoreManager;
	}
	
	/**
	 * Ritorna il {@link ILocalStatsManager} corrente.
	 * @return Manager per i punteggi locali corrente
	 */
	public ILocalStatsManager getLocalStats() {
		return localStats;
	}
	
	/**
	 * Ritorna il {@link IScoreManager} corrente.
	 * @return Manager per i punteggi corrente
	 */
	public IScoreManager getScoreManager() {
		return scoreManager;
	}

}
