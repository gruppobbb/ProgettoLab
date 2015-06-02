package model.scores;

/**
 * Interfaccia che astrae sul componente client, che si occupa di dialogare con il server.
 * @author Giulia
 */
public interface IClient {
	
	/**
	 * Avvia il client.
	 * @param port Porta della connessione
	 * @param hostName Nome dell'host
	 */
	public void start(int port, String hostname);

}
