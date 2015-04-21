package model.server;

import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author Giulia
 *
 */

public interface IService {
	
	/**
	 * TODO: fissare il 'filename', sostituirlo con il
	 * componente 'RichiestaHTTP'
	 * 
	 * @param clientSocket
	 * @param uri
	 * @return
	 * @throws IOException
	 */

	public void sendHTTP(final Socket clientSocket, HttpRequest request)
			throws IOException;

}
