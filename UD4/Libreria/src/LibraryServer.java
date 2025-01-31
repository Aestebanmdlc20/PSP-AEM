import java.io.IOException;
import java.net.ServerSocket;

public class LibraryServer {
    public static void main(String[] args) throws IOException {

        System.out.println("Servidor iniciadose....");
        Libreria libreria = new Libreria();

        try(ServerSocket serverSocket = new ServerSocket(5000)){

            while(true){
                new ClientHandler(serverSocket.accept(), libreria).start();
            }

        }  catch (IOException e) {
            throw e;
        }

    }
}
