/**
 * Crear un hilo que visualice por pantalla 
 * en un bucle infinito la palabra TIC
 * Dentro del bucle, utiliza el método sleep() 
 * para que nos de tiempo a ver las palabras 
 * que se visualizan cuando lo ejecutemos
 * 
 * @author santa
 *
 */
public class HiloTIC extends Thread {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("TIC");
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
