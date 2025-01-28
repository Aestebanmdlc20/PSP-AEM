import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Conector {
	public static void main(String[] args) throws Exception {
		String url = "www.google.es";
		int puerto = 443; //HTTPS

		SSLSocketFactory factory = null;
		SSLSocket socket = null;
		FileWriter fWriter = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			socket = (SSLSocket) factory.createSocket(url, puerto);

			// Escribo peticion a google
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			out.println("GET /index.html");
			out.println();
			out.flush();

			/*
			 * Comprobar que no ha ocurrido ning�n error
			 */
			if (out.checkError()) {
				System.out.println("SSLSocketClient:  java.io.PrintWriter error");
			}

			/* leer respuesta */
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String inputLine;
			fWriter = new FileWriter("resultado.html");
			while ((inputLine = in.readLine()) != null) {
				fWriter.write(inputLine);
			}

		} catch (IOException e) {
			System.out.println("No se pudo establecer la conexion o hubo un fallo al leer datos. " + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			if (null != in) {
				in.close();
			}
			if (null != out) {
				out.close();
			}
			if (null != fWriter) {
				fWriter.close();
			}
			if (null != socket) {
				socket.close();
			}
		}
	} // Fin del main
} // Fin de la clase Conector