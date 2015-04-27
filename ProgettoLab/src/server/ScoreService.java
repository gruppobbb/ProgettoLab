package server;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import model.scores.ScoreKeeper;

/**
 * Service per il caricamento di una pagina con la lista degli High Score.
 * @author Giulia
 *
 */

public class ScoreService implements IService{
	
	private ScoreKeeper scores = ScoreKeeper.getScoreKeeper();
	
	public void sendHTTP(final Socket clientSocket,
			HttpRequest request) throws IOException,
			FileNotFoundException {
		
		HttpMessage message = new HttpMessage();
		message.openHttpAnswer(clientSocket);
		copyFile(message.getOut());
		message.closeHttpAnswer();
	}
	
	/**
	 * Carica il file HTML, sostituendo "$SCORES$" con la lista dei punteggi.
	 */
	private void copyFile(OutputStreamWriter out)
			throws FileNotFoundException, IOException {
		BufferedReader fileReader = new BufferedReader(
				new FileReader("web/highscores.html")
				);
		String fileLine=fileReader.readLine();
		while(fileLine!=null){
			if(fileLine.trim().equals("$SCORES$")){
				out.write("<ol>\n");
				for (int i = 0; i < ScoreKeeper.MAX_SCORES; i++) {
					out.write("<li>");
					out.write(scores.getHighScores().get(i).toString());
					out.write("");
					out.write("</li>\n");
				}
				out.write("</ol>");
			}else{
				out.write(fileLine+"\n");
			}
			fileLine=fileReader.readLine();
		}
		fileReader.close();
	}

}