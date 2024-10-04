
public class UsaHilo3 {
	
	public static void main (String[] args) {
		HiloSimple3 hs1 = new HiloSimple3("HILO PRUEBA 1", 10);
		HiloSimple3 hs2 = new HiloSimple3("HILO PRUEBA 2", 20);
		HiloSimple3 hs3 = new HiloSimple3("HILO PRUEBA 3", 30);
		
		hs1.start();
		hs2.start();
		hs3.start();
	}

}
