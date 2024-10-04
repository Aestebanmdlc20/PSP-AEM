/**
 * El uso de suspend() está obsoleto ya que podia producir interbloqueos
 * Ejemplo de suspender de forma seguro el hilo
 * @author santa
 *
 */
public class HiloSuspender extends Thread {

	private SolicitarSuspender solicitar;
	private boolean continuar;
	private int contador = 0;

	public HiloSuspender() {
		this.solicitar = new SolicitarSuspender();
		this.continuar = true;
		this.contador = 0;
	}

	public void suspende() {
		solicitar.setSuspender(true);
	}

	public void reanuda() {
		solicitar.setSuspender(false);
	}
	
	public void setContinuar(boolean value) {
		this.continuar = value;
	}
	
	public int getContador() {
		return contador;
	}

	@Override
	public void run() {
		try {
			while (continuar) {
				contador++;
				System.out.println("Contador: "+contador);
				
				sleep(1);
				solicitar.esperando();// mandar suspender el hilo
			}
			System.out.println("Fin HiloSuspender");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
