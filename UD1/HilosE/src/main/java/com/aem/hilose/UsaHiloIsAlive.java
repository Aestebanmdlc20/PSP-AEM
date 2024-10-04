
public class UsaHiloIsAlive {
	
	public static void main (String[] args) throws InterruptedException {
		HiloIsAlive hs = new HiloIsAlive();
		hs.start();
		while(hs.isAlive()) {
			System.out.println("Sigue vivo...");
		}
		
		System.out.println("Terminó de ejecutarse UsaHiloIsAlive");
	}

}
