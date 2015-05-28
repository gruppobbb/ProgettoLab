package model.scores;

public interface ILocalStatsManager {
	
	public void setPersonalBest(long score);
	public long getPersonalBest();
	public void setPlayerName(String playerName);
	public String getPlayerName();

}
