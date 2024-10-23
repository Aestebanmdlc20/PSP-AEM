package org.example;

public class Usuario  implements  Runnable{

    private int pisoDestino;
    Ascensor ascensor;

    public Usuario(int pisoDestino, Ascensor ascensor) {
        this.pisoDestino = pisoDestino;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        ascensor.moverAscensor(this.pisoDestino);
    }
}
