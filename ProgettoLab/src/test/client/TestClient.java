package test.client;

import model.scores.LocalScoreManager;
import model.scores.ManagerKeeper;
import model.scores.XMLLocalStatsManager;
import model2D.client.LocalClient;

public class TestClient {
	
	public static void main(String[] args) {
		
		ManagerKeeper.getInstance().setLocalStats(new XMLLocalStatsManager("web/localstats.xml"));
		ManagerKeeper.getInstance().setScoreManager(new LocalScoreManager("web/scorelist.xml"));

		LocalClient client = new LocalClient();
		
		client.start(8080, "127.0.0.1");
	}

}
