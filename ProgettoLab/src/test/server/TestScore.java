package test.server;

import server.ScoreService;
import server.Server;
import model.scores.ScoreCalculator;

public class TestScore {
	
	public final static int PORT = 8080;
	
	public static void main(String[] args) {
		
		ScoreCalculator calc = new ScoreCalculator();
		calc.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calc.stop();
		
		Server server = new Server(PORT);
		
		server.addService("/highscores", new ScoreService());
		
		server.launch();
		
	}

}