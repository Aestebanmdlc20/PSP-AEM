
public class UsaHiloSuspender {
	
	public static void main (String[] args) throws InterruptedException {
		HiloSuspender hs = new HiloSuspender();
		hs.start();
		
		int contador=10000;
		while(contador >= 0) {
			if ((contador % 2) == 0) {
				//si es par
				hs.reanuda();
			}
			else {
				hs.suspende();
			}
			contador--;
		}
		
		hs.setContinuar(false);
		System.out.println("Valor de contador al terminar:"+hs.getContador());
	}

}
