package test.server;

import model.server.ScoreService;
import model.server.Server;

public class TestScore {
	
	public final static int PORT = 8080;
	
	public static void main(String[] args) {
		
		Server server = new Server(PORT);
		
		server.addService("/highscores", new ScoreService());
		
		server.launch();
		
	}

}