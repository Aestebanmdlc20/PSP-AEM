

public class UsarCarrera {

	public static void main(String[] args) throws Exception {
		//crear hilos
		Carrera conejo = new Carrera(1,"conejo");
		Carrera liebre = new Carrera(5,"liebre");
		Carrera tortuga = new Carrera(8,"tortuga");
		
		//arrancar hilos		
		conejo.start();
		liebre.start();
		tortuga.start();
		
		//esperar a que terminen
		conejo.join();
		liebre.join();
		tortuga.join();

	}

}
