package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		while (true) {
			Socket socket = serverSocket.accept();
			ClientHandler hilo = new ClientHandler(socket);
			hilo.start();
		}
	}

	
}
