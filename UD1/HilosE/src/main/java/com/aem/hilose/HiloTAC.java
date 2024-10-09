
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
    TicTac tictac;
    public HiloTAC(TicTac tictac){
        this.tictac=tictac;
    }
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("TAC");
                tictac.avisar();
                tictac.esperar();
                this.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTAC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }       
}
