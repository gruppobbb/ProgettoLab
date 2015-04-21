package model.server;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import model.scores.ScoreKeeper;


public class ScoreService implements IService{
	
	private ScoreKeeper scores = ScoreKeeper.getScoreKeeper();
	private static final String filename = "web/highscores.html";
	
	public void sendHTTP(final Socket clientSocket,
			HttpRequest request) throws IOException,
			FileNotFoundException {
		
		HttpMessage message = new HttpMessage();
		message.openHttpAnswer(clientSocket);
		copyFile(filename, message.getOut());
		message.closeHttpAnswer();
	}

	private void copyFile(String filename,
			OutputStreamWriter out)
			throws FileNotFoundException, IOException {
		BufferedReader fileReader = new BufferedReader(
				new FileReader(filename)
				);
		String fileLine=fileReader.readLine();
		while(fileLine!=null){
			if(fileLine.trim().equals("$SCORES$")){
				out.write("<ol>\n");
				for (int i = 0; i < ScoreKeeper.MAX_SCORES; i++) {
					out.write("<li>");
					out.write(scores.getHighScores().get(i).toString());
					out.write("</li>\n");
				}
				out.write("</ol>");
			}else{
				out.write(fileLine+"\n");
			}
			fileLine=fileReader.readLine();
		}
	}
	
	private String checkURI(String uri) {
		String filename = "web" + uri;
		File file = new File(filename);
		if(!file.exists()){
			filename = "web/error.html";
		}
		return filename;
	}

}