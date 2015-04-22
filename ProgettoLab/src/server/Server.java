package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Classe che gestisce la connessione col server locale.
 * @author Giulia
 *
 */

public class Server {
	
	private HashMap<String, IService> services = new HashMap<String, IService>();
	public int port;
	private static ServerSocket socket;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void addService(String name, IService service){
		services.put(name, service);
	}
	
	public void launch() {
		try {
			socket = new ServerSocket(port);

			while (true) {
				final Socket clientSocket = socket.accept();
				Runnable runnable = new Runnable() {

					@Override
					public void run() {
						try {
							HttpRequest request = new HttpRequest(clientSocket);
														
							System.err.println(request.getUri());
							
							IService service = services.get(request.getUri());
							if(service==null){
								service = new FileService();
							}
							
							service.sendHTTP(clientSocket, request);

							clientSocket.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				};
				Thread thread = new Thread(runnable);
				thread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}