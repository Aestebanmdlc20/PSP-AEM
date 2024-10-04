package com.aem.hilose;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crear un hilo que visualice por pantalla 
 * en un bucle infinito la palabra TIC
 * Dentro del bucle, utiliza el m�todo sleep() 
 * para que nos de tiempo a ver las palabras 
 * que se visualizan cuando lo ejecutemos
 * 
 * @author santa
 *
 */
public class HiloTIC extends Thread {
    protected static boolean ticTurno = true; 
	@Override
	public void run() {
		while(true) {
                    sincronizarTIC(this);
		}
	}
        
        public synchronized void sincronizarTIC(HiloTIC tic){
            while (!ticTurno) {  
                try {
                    HiloTIC.class.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloTIC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("TIC");
            ticTurno = false;  
            HiloTIC.class.notifyAll();
        }
        
}
