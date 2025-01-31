import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LibraryCliente {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 5000);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());){

            System.out.println("Cliente conectado al servidor");

            // Pedir un libro
            Libro libro = new Libro("El principito",7);
            salida.writeObject(libro);

            String serverResponse;

            while((serverResponse = entrada.readLine()) != null){
                System.out.println("Respuesta del servidor " + serverResponse);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
