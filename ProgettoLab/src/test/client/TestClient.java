package test.client;

import model2D.client.LocalClient;

public class TestClient {
	
	public static void main(String[] args) {

		LocalClient client = new LocalClient();
		
		client.start(8080, "127.0.0.1");
	}

}
