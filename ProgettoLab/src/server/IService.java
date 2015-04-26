package server;

import java.io.IOException;
import java.net.Socket;

/**
 * Servizi per mandare richieste HTTP.
 * @author Giulia
 */

public interface IService {
	
	/**
	 * Manda una richiesta HTTP personalizzata in base al servizio istanziato.
	 */

	public void sendHTTP(final Socket clientSocket, HttpRequest request)
			throws IOException;

}
