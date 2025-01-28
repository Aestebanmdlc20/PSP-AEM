package socketDatagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EmisorDatagram {

	public static void main(String[] args) throws IOException {
		try {
			System.out.println("EmisorDatagram:Creando socket datagram");
			DatagramSocket datagramsocket = new DatagramSocket();
			System.out.println("EmisorDatagram: Enviando mensaje");
			
			String mensaje = "mensaje desde el emisor";
			
			InetAddress addr = InetAddress.getByName("localhost");
			DatagramPacket datagrama_ = new DatagramPacket (mensaje.getBytes(),
					mensaje.getBytes().length,addr,5555);
			
			datagramsocket.send(datagrama_);
			System.out.println("Mensaje enviado");
			
			byte[] buffer = new byte[25];
			DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
			datagramsocket.receive(respuesta);
            System.out.println("Respuesta del servidor: " + new String(respuesta.getData()));
            
			System.out.println("Cerrando el socket datagrama");
			datagramsocket.close();
			
			System.out.println("Terminado");
			
		} catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
