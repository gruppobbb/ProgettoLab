package server;

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

import model.scores.ScoreKeeper;

public class LocalClient {
	
	private File file;
	
	public LocalClient() {
		this.file = new File(ScoreKeeper.SCOREFILENAME);
	}
	
	
	/**
	 * Avvia il client.
	 * @param port Porta della connessione
	 * @param hostname Nome dell'host
	 */
	public void start(int port, String hostname) {
		
		try {
			Socket clientSocket = new Socket(hostname, port);

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			sendScores(out);
			out.close();
			
//			BufferedReader in = new BufferedReader(
//					new InputStreamReader(clientSocket.getInputStream()));
//			saveScores(in);
//			in.close();

			clientSocket.close();
		} catch (UnknownHostException e) {
			System.err.println("Impossibile connettersi all'host " + hostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Errore durante la comunicazione con l'host " +
					hostname);
			System.exit(1);
		}
	}
	
	/**
	 * Manda i punteggi da locale a server.
	 * @param out output verso il server
	 * @throws IOException
	 */
	private void sendScores(PrintWriter out) throws IOException{
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String fromUser;
		while ((fromUser = fileReader.readLine()) != null) {
			out.println(fromUser);
		}
		fileReader.close();
		out.close();
	}
	
	/**
	 * Riceve i punteggi da server a locale.
	 * @param in input da server
	 * @throws IOException
	 */
	private void saveScores(BufferedReader in) throws IOException{
		file.delete();
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
		String fromServer;
		while((fromServer = in.readLine()) != null){
			fileWriter.write(fromServer);
			fileWriter.newLine();
		}
		fileWriter.close();
		in.close();
		
	}
	


}
