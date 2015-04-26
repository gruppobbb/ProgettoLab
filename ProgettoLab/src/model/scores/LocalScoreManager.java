package model.scores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Memorizza i punteggi in locale.
 * @author Giulia
 */

public class LocalScoreManager implements IScoreManager{
	
//	public final static int PORT = 8080;
//	private Server server;
	String scoreList;
	
	
	public LocalScoreManager() {
		scoreList = "web/scorelist.txt";
		//TODO: Interazione server locale
//		this.server = new Server(PORT);
//		server.addService("/highscores", new ScoreService());
//		server.launch();
	}
	

	public void loadScores(ArrayList<Long> highScores) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader(scoreList));
		highScores.clear();
		for (int i = 0; i < ScoreKeeper.MAX_SCORES; i++) {
			highScores.add(Long.decode(reader.readLine()));
		}
		reader.close();
		trimScoreList(highScores);
		
	}
	
	public void saveScores(ArrayList<Long> highScores) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(scoreList));
		trimScoreList(highScores);
		for (int i = 0; i < ScoreKeeper.MAX_SCORES; i++) {
			writer.write(highScores.get(i).toString());
			if (i != ScoreKeeper.MAX_SCORES) {
				writer.write("\n");
			}
		}
		writer.close();
	}

	/**
	 * Riduce la lista dei punteggi a 10 elementi.
	 * @param highScores Lista dei punteggi passata da ScoreKeeper
	 */
	public void trimScoreList(ArrayList<Long> highScores){
		Collections.sort(highScores);
		Collections.reverse(highScores);
		if (highScores.size() > ScoreKeeper.MAX_SCORES) {
			highScores.subList(ScoreKeeper.MAX_SCORES, highScores.size()).clear();
		}
	}

}
