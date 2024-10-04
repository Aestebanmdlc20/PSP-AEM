
public class HiloSimple3 extends Thread {
	
	private int x;
	public HiloSimple3(String nombre, int x) {
		super(nombre);
		this.x = x;
	}
	
	@Override
	public void run() {
		//Acciones que lleva a cabo el hilo
		System.out.println("Hola soy "+this.getName()+" y me pasaron el valor: "+x);
	}
}
