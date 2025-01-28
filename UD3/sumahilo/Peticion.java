package sumahilo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Peticion extends Thread {
	
	Socket socket;
	public Peticion(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			escuchar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int extraerNumero(String linea) {
		/*
		 * 1. Comprobar si es un numero 
		 * 2. Ver si el numero es correcto (32a75) 
		 * 3. Ver si tiene de 1 a 8 cifras
		 */
		int numero;
		try {
			numero = Integer.parseInt(linea);
		} catch (NumberFormatException e) {
			numero = 0;
		}
		/*
		 * Si el numero es mayor de 100 millones tampoco es valido
		 */
		if (numero >= 100000000) {
			numero = 0;
		}
		return numero;
	}

	private int calcular(String op, String n1, String n2) {
		int resultado = 0;
		char simbolo = op.charAt(0);
		int num1 = this.extraerNumero(n1);
		int num2 = this.extraerNumero(n2);
		if (simbolo == '+') {
			resultado = num1 + num2;
			System.out.println("Resultado suma: "+num1+" + "+num2+" = "+resultado);
		}
		return resultado;
	}
	
	private void escuchar() throws IOException {
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader bf = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			System.out.println("Conexion recibida!");
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			bf = new BufferedReader(isr);
			String linea = bf.readLine();
			String num1 = bf.readLine();
			String num2 = bf.readLine();
			/* Calculamos el resultado */
			Integer result = this.calcular(linea, num1, num2);
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write(result.toString() + "\n");
			pw.flush();
		} catch (IOException e) {
			System.out.println("Error al aceptar conexion "+e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			close(pw);
			close(os);
			close(bf);
			close(isr);
			close(is);
			try {
				if (null != socket) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	private void close(Closeable stream) {
		try {
			if (null != stream) {
				stream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

}
