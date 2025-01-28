package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 12345);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// leer mensaje del servidor
		new Thread(() -> {
			try {
				String serverMessage;
				while ((serverMessage = in.readLine()) != null) {
					System.out.println("Leer mensaje del servidor: " + serverMessage);
				}
			} catch (IOException e) {
                e.printStackTrace();
            }
		}).start();

		// mandar mensaje al servidor
		Mensaje mensaje = new Mensaje();
		out.println(mensaje.getMensaje());
	}
}
