
package com.aem.hilose;

import static com.aem.hilose.HiloTIC.ticTurno;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crear un hilo que visualice por pantalla 
 * en un bucle infinito la palabra TAC
 * Dentro del bucle, utiliza el m�todo sleep() 
 * para que nos de tiempo a ver las palabras 
 * que se visualizan cuando lo ejecutemos
 * 
 * @author santa
 *
 */
public class HiloTAC extends Thread {
	
	@Override
	public void run() {
		while(true) {
                    sincronizarTAC();
                }    
	}
        
        public synchronized void sincronizarTAC() {
        while (!ticTurno) {
            try {
                this.wait(); // wait on the current instance
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTAC.class.getName()).log(Level.SEVERE, null, ex);
                // Handle interruption appropriately, maybe break the loop
            }
        }
        System.out.println("TAC");
        ticTurno = false; // Set to false, signaling it's not this thread's turn
        notifyAll(); // Notify all waiting threads
    }

    // Additional method to allow HiloTIC to notify
        public static synchronized void setTicTurno(boolean turno) {
            ticTurno = turno;
            if (turno) {
                HiloTAC.class.notifyAll(); // Notify HiloTAC when it's its turn
            }
        }
}
