package com.aem.hilose;

public class UsaHiloTICTAC {

    public static void main (String[] args) {
        TicTac tictac = new TicTac();

        HiloTIC hTIC = new HiloTIC(tictac);
        HiloTAC hTAC = new HiloTAC(tictac);

        // Los arranco
        hTIC.start();
        hTAC.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hTIC.interrupt();
        hTAC.interrupt();
        
    }
}