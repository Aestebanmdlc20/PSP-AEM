// HiloTIC.java
package com.aem.hilose;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloTIC extends Thread {
    TicTac tictac;
    protected static boolean ticTurno = true;
    public HiloTIC(TicTac tictac) {
        this.tictac = tictac;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("TIC");
                tictac.avisar();
                tictac.esperar();
                this.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTIC.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt(); // Vuelve a interrumpir el hilo
            }
        }
    }
}