import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{

    private Socket socket;
    private Libreria libreria;

    public ClientHandler(Socket socket, Libreria libreria) {
        this.socket = socket;
        this.libreria = libreria;
    }

    @Override
    public void run() {
        try(ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true)) {

            // Leer peticion
            Libro libroSolicitado = (Libro) entrada.readObject();
            System.out.println("Peticion recibida: " + libroSolicitado.getNombre());

            // Comprobar si hay disponibilidad

            Libro libroDevuelto = libreria.atenderPedidos(libroSolicitado);
            if (libroSolicitado.getNumLibros() == libroDevuelto.getNumLibros()){
                salida.println("Libros enviados: " + libroDevuelto.getNombre() + " " + libroDevuelto.getNumLibros());
            } else {
                salida.println("No hay suficientes libros disponibles " + libroDevuelto.getNombre() + " " + libroDevuelto.getNumLibros());
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
