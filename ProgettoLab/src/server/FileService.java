package server;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class FileService implements IService{
		
	public void sendHTTP(final Socket clientSocket,
			HttpRequest request) throws IOException,
			FileNotFoundException {
		
		String filename = checkURI(request.getUri());
		
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
			out.write(fileLine+"\n");
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