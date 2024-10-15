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
    TicTac tictac;
    protected static boolean ticTurno = true; 
    public HiloTIC(TicTac tictac) {
		this.tictac = tictac;
    }
	@Override
    public void run() {
        while(true) {
            try {
                System.out.println("TIC");
                tictac.avisar();
                tictac.esperar();

                this.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTIC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
}
