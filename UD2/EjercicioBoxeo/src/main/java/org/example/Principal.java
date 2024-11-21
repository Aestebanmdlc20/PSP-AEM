package org.example;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Ring ring = new Ring();
        Boxeador boxeador1 = new Boxeador("Boxeador 1", ring);
        Boxeador boxeador2 = new Boxeador("Boxeador 2", ring);
        Boxeador boxeador3 = new Boxeador("Boxeador 3", ring);
        Boxeador boxeador4 = new Boxeador("Boxeador 4", ring);

        boxeador1.setRival(boxeador2);
        boxeador2.setRival(boxeador1);
        boxeador3.setRival(boxeador4);
        boxeador4.setRival(boxeador3);

        Thread hilo1 = new Thread(boxeador1);
        Thread hilo2 = new Thread(boxeador2);
        Thread hilo3 = new Thread(boxeador3);
        Thread hilo4 = new Thread(boxeador4);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            throw e;
        }

        System.out.println(boxeador1);
        System.out.println(boxeador2);
        System.out.println(boxeador3);
        System.out.println(boxeador4);


    }
}