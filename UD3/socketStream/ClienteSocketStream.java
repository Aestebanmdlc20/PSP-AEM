package socketStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.InetSocketAddress;

public class ClienteSocketStream {

	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo la conexión");
			
			InetSocketAddress addr = new InetSocketAddress ("localhost", 5555);
			clientSocket.connect(addr);
			
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			System.out.println("Enviando mensaje");
			
			String mensaje = "hola clase!!\n";
			os.write(mensaje.getBytes());
			System.out.println("mensaje enviado");
			System.out.println("Cerrando el socket cliente");
			clientSocket.close();
			System.out.println("Terminado");
			
		} catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
