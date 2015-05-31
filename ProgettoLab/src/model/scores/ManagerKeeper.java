package model.scores;

public class ManagerKeeper {
	
	private static ManagerKeeper managerKeeper;
	
	private IScoreManager scoreManager;
	private ILocalStatsManager localStats;
	
	private ManagerKeeper(){
		
	}
	
	public static ManagerKeeper getInstance(){
		if(managerKeeper == null){
			managerKeeper = new ManagerKeeper();
		}
		return managerKeeper;
	}
	
	public void setLocalStats(ILocalStatsManager localStats) {
		this.localStats = localStats;
	}
	
	public void setScoreManager(IScoreManager scoreManager) {
		this.scoreManager = scoreManager;
	}
	
	public ILocalStatsManager getLocalStats() {
		return localStats;
	}
	
	public IScoreManager getScoreManager() {
		return scoreManager;
	}

}
