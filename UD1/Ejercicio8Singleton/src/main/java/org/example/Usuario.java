package org.example;

public class Usuario implements Runnable{

    private int pisoDestino;
    private Ascensor ascensor;

    public Usuario(int pisoDestino,Ascensor ascensor) {
        this.pisoDestino = pisoDestino;
        this.ascensor=ascensor;
    }

    @Override
    public void run() {
        ascensor.moverAscensor(this.pisoDestino);
        System.out.println("El usuario se ha movido al piso " + this.pisoDestino);
    }
}
