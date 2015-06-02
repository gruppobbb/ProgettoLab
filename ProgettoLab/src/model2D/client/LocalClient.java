package model2D.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import model.scores.IClient;
import model.scores.ManagerKeeper;

/**
 * Client che permette di comunicare col Server locale su PC.
 * @author Giulia
 */
public class LocalClient implements IClient {
	
	private File file;
	
	public LocalClient() {
		this.file = ManagerKeeper.getInstance().getScoreManager().getScoreFile();
	}
	
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
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String fromUser;
		while ((fromUser = fileReader.readLine()) != null) {
			out.println(fromUser);
		}
		fileReader.close();
	}
	
	private void saveScores(BufferedReader in) throws IOException{
		file.delete();
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
		String fromServer;
		while((fromServer = in.readLine()) != null){
			fileWriter.write(fromServer);
			fileWriter.newLine();
		}
		fileWriter.close();
	}
}
