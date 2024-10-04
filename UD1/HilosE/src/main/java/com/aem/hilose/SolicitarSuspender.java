
public class SolicitarSuspender {

	private boolean suspender;
	
	public synchronized void setSuspender(boolean suspender) {
		System.out.println("Solicita suspender: "+suspender);
		this.suspender = suspender;
		//notifica a todos los hilos que esperan 
		//(por haber ejecutado un wait)
		//un cambio de estado
		notifyAll();
	}
	
	public synchronized void esperando() throws InterruptedException {
		while(suspender) {
			System.out.println("Wait");
			//suspender hilo hasta recibir notify o notifyAll
			//el metodo wait solo puede ser llamado desde un metodo sincronizado
			//wait, notify y notifyAll (Object) se usan en hilos sincronizados
			wait();
		}
	}

}
