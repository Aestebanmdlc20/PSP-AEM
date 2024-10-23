package org.example;

public class SimuladorAscensor {
    public static void main(String[] args) {
        Ascensor ascensor = Ascensor.getInstance(0, 10);

        Thread u1 = new Thread(new Usuario(1,ascensor));
        Thread u2 = new Thread(new Usuario(5,ascensor));
        Thread u3 = new Thread(new Usuario(3,ascensor));
        Thread u4 = new Thread(new Usuario(9,ascensor));

        u1.start();
        u2.start();
        u3.start();
        u4.start();

        try{
            u1.join();
            u2.join();
            u3.join();
            u4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Simulacion terminada!");

    }
}