package test.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.server.Servlet;

public class TestScore {
	
	public static final int PORT = 8080;
	private static Servlet servlet = new Servlet();
	private static ServerSocket socket;
	private static boolean isRunning = true;

	public static void main(String[] args) {

		try {
			socket = new ServerSocket(PORT);
			while (isRunning) {
				final Socket clientSocket = socket.accept();
				Runnable runnable = new Runnable() {

					@Override
					public void run() {
						try {
							BufferedReader fileReader = servlet.sendHTTP(clientSocket);
								
							fileReader.close();
							clientSocket.close();
//							socket.close();
						} catch (IOException e) {
//							isRunning = false;
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