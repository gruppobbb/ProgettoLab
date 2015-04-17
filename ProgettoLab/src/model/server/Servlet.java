package model.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Classe che gestisce la connessione col server locale.
 * @author Giulia
 *
 */

public class Servlet {

	public ScoreKeeper scores = ScoreKeeper.getScoreKeeper();
	
	/**
	 * Manda la richiesta HTTP al server.
	 * @param clientSocket Socket del Client
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */
	public BufferedReader sendHTTP(final Socket clientSocket) throws IOException{
		OutputStreamWriter out = new 
				OutputStreamWriter(
						clientSocket.getOutputStream(),
						Charset.forName("UTF-8").newEncoder()
						);
		out.write("HTTP/1.1 200 OK\n");
		out.write("Date: Thu, 16 Apr 2015 22:37:00\n");
		out.write("Content-Type text/html; charset=utf-8\n");
		out.write("\n");
		

		BufferedReader fileReader = copyFile(out);
		
		out.write("\n");
		out.close();
		return fileReader;
	}
	
	/**
	 * Copia il contenuto del file nella finestra del browser, inclusa la lista dei punteggi.
	 * @param out
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public BufferedReader copyFile(OutputStreamWriter out)
			throws FileNotFoundException, IOException {
		BufferedReader fileReader = new BufferedReader(
				new FileReader("web/highscores.html")
				);
		String fileLine=fileReader.readLine();
		while(fileLine!=null){
			if(fileLine.trim().equals("$SCORES$")){
				out.write("<ol>\n");
				for (int i = 0; i < scores.getHighScores().size(); i++) {
					out.write("<li>");
					out.write(scores.getHighScores().get(i).toString());
					out.write("</li>\n");
				}
				out.write("</ol>\n");
			}else{
				out.write(fileLine+"\n");
			}
			fileLine=fileReader.readLine();
		}
		return fileReader;
	}

}
