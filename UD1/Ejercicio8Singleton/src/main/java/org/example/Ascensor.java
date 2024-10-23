package org.example;

public class Ascensor {
    // Modelo Singleton

    private static Ascensor instance;

    private int pisoActual;
    private int maxPisos;

    private Ascensor(int pisoActual, int maxPisos){
        this.pisoActual = pisoActual;
        this.maxPisos = maxPisos;
    }

    private synchronized static void createInstance(int pisoActual, int maxPisos){
        if(instance == null){
            instance = new Ascensor(pisoActual,maxPisos);
        }
    }

    public static Ascensor getInstance(int pisoActual, int maxPisos){
        if (instance == null){
            createInstance(pisoActual,maxPisos);
        }
        return instance;
    }

    public synchronized void moverAscensor(int pisoDestino){

        if(this.pisoActual != pisoDestino || this.pisoActual < this.maxPisos){
            System.out.println("Moviendo al piso: " + pisoDestino + "...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pisoActual=pisoDestino;
            System.out.println("El ascensor ha llegado " + pisoDestino);
        }

    }

}
