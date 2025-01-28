package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

class ClientHandler extends Thread {
	private Socket socket;
	//añadir los clientes
	private static Set<PrintWriter> clientWriters = new HashSet<>();

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			synchronized (clientWriters) {
				clientWriters.add(out);
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message;
			while ((message = in.readLine()) != null) {
				//cada mensaje recibido por un cliente es enviado a todos
				System.out.println("Mensaje recibido: " + message);
				synchronized (clientWriters) {
					for (PrintWriter writer : clientWriters) {
						writer.println(message);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			synchronized (clientWriters) {
				clientWriters.remove(out);
			}
		}
	}
}
