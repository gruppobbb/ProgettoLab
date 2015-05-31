package model.scores;

public interface IClient {
	
	/**
	 * Avvia il client.
	 * @param port Porta della connessione
	 * @param hostName Nome dell'host
	 */
	public void start(int port, String hostname);

}
