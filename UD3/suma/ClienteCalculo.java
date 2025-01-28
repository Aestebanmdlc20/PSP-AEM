package suma;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteCalculo {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		Socket socket = null;
		BufferedReader bfr = null;
		PrintWriter pw = null;
		InputStreamReader isr = null;
		try {
			InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
			socket = new Socket();
			socket.connect(direccion);
			//Escribe la peticion al servidor
			pw = new PrintWriter(socket.getOutputStream());
			pw.print("+\n");
			pw.print("0\n");
			pw.print("84\n");
			pw.flush();
			//lee la respuesta del servidor
			isr = new InputStreamReader(socket.getInputStream());
			bfr = new BufferedReader(isr);
			String resultado = bfr.readLine();
			System.out.println("El resultado fue:" + resultado);
		}
		catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			close(pw);
			close(bfr);
			close(isr);
			close(socket);
		}
	}
	
	private static void close(Closeable socket) {
		try {
			if (null != socket) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
