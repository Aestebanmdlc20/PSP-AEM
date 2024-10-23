package org.example;

public class Ascensor {

    private int pisoActual;
    private int maxPisos;

    public Ascensor(int pisoActual, int maxPisos) {
        this.pisoActual = pisoActual;
        this.maxPisos = maxPisos;
    }

    public synchronized void moverAscensor(int pisoDestino) {

        if (pisoActual != pisoDestino || pisoActual != maxPisos) {
            pisoActual = pisoDestino;
            try {
                Thread.sleep(1000);
                System.out.println("Has llegado al piso " + pisoActual);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
