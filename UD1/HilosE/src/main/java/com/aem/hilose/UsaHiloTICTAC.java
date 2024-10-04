/**
 * Main hace uso de los hilos TIC TAC
 * ¿Se visualizan los texto TIC TAC de forma ordenada?
 * @author santa
 *
 */
public class UsaHiloTICTAC {
	
	public static void main (String[] args) {
		//Creo los hilos
		HiloTIC hTIC = new HiloTIC();
		HiloTAC hTAC = new HiloTAC();
		
		//los arranco
		hTIC.start();
		hTAC.start();
		
	}

}
