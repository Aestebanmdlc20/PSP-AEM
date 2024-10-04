
public class UsaHilo2 {
	
	public static void main (String[] args) {
		HiloSimple2 hs = new HiloSimple2();
		Thread t = new Thread(hs);
		t.start();
		System.out.println("Terminó de ejecutarse HiloSimple");
	}

}
