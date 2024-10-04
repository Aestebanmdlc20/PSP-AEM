/**
 * Crear un hilo que visualice por pantalla 
 * en un bucle infinito la palabra TAC
 * Dentro del bucle, utiliza el método sleep() 
 * para que nos de tiempo a ver las palabras 
 * que se visualizan cuando lo ejecutemos
 * 
 * @author santa
 *
 */
public class HiloTAC extends Thread {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("TAC");
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
