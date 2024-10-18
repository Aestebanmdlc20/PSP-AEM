// HiloTAC.java
package com.aem.hilose;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloTAC extends Thread {
    TicTac tictac;
    public HiloTAC(TicTac tictac) {
        this.tictac = tictac;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("TAC");
                tictac.avisar();
                tictac.esperar();
                this.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTAC.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt(); // Vuelve a interrumpir el hilo
            }
        }
    }
}