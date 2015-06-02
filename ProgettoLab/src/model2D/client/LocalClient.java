package model2D.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import model.scores.IClient;
import model.scores.ManagerKeeper;
import model.scores.ScoreEntry;
import model.scores.ScoreKeeper;

/**
 * Client che permette di comunicare col Server locale su PC.
 * @author Giulia
 */
public class LocalClient implements IClient {
	
	private ScoreKeeper scores = ScoreKeeper.getInstance();	
	
	/**
	 * @see IClient
	 */
	@Override
	public void start(int port, String hostName) {
		
		try (
				Socket clientSocket = new Socket(hostName, port);
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				) {
			
			sendScores(out);
			out.println("SCORES SENT");
			saveScores(in);

		} catch (UnknownHostException e) {
			System.err.println("Impossibile connettersi all'host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Errore durante la comunicazione con l'host " +
					hostName);
			System.exit(1);
		}
	}
	
	private void sendScores(PrintWriter out) throws IOException{
		for (int i = 0; i < ScoreKeeper.MAX_SCORES; i++) {
			ScoreEntry scoreEntry = scores.getHighScores().get(i);
			out.println(scoreEntry.getPlayerName() + "," + scoreEntry.getScore());
		}
	}
	
	private void saveScores(BufferedReader in) throws IOException{
		ArrayList<ScoreEntry> highScores = new ArrayList<ScoreEntry>();
		String fromServer;
		while((fromServer = in.readLine()) != null){
			String[] entryValues = fromServer.split(",");
			ScoreEntry entry = new ScoreEntry();
			entry.setPlayerName(entryValues[0]);
			entry.setScore(Long.parseLong(entryValues[1]));
			highScores.add(entry);
		}
		ManagerKeeper.getInstance().getScoreManager().saveScores(highScores);
	}
}
