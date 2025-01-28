package sumahilo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculoHilo {

	public static void main(String[] args) throws Exception {
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9876);
			System.out.println("Arrancado el servidor");
			while (true){
				try {
					Socket conexion=socketEscucha.accept();
			        Peticion hilo=new Peticion(conexion);
			        hilo.start();
				}
				catch(IOException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			try {
				if (null != socketEscucha) {
					socketEscucha.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
