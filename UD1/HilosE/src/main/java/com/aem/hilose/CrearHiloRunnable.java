
/**
 * Usar este modo si necesitamos heredar de otra clase
 */
public class CrearHiloRunnable implements Runnable {

	@Override
	public void run() {
		//Acciones que lleva a cabo el hilo
		System.out.println("Hola soy "+Thread.currentThread().getName()
				+"\n Prioridad: "+Thread.currentThread().getPriority()
				+"\n ID: "+Thread.currentThread().getId()
				+"\n Hilos activos: "+Thread.currentThread().activeCount());
		
	}

}
