package com.aem.hilose;

/**
 * Main hace uso de los hilos TIC TAC
 * ¿Se visualizan los texto TIC TAC de forma ordenada?
 * @author santa
 *
 */
public class UsaHiloTICTAC {

    public static void main (String[] args) {
        TicTac tictac = new TicTac();
        // Creo los hilos
        HiloTIC hTIC = new HiloTIC(tictac);
        HiloTAC hTAC = new HiloTAC(tictac);

        // Los arranco
        hTIC.start();
        hTAC.start();

        try {
            // Espera 5 segundos
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Interrumpe los hilos
        hTIC.interrupt();
        hTAC.interrupt();
    }
}