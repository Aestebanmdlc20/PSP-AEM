package org.example;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Filosofo f1 = new Filosofo("[Platón]", mesa.getTenedor1(), mesa.getTenedor2(), 1);
        Filosofo f2 = new Filosofo("[Descartes]", mesa.getTenedor2(), mesa.getTenedor3(), 1);
        Filosofo f3 = new Filosofo("[Rousseau]", mesa.getTenedor3(), mesa.getTenedor4(), 1);
        Filosofo f4 = new Filosofo("[Bertrand]", mesa.getTenedor4(), mesa.getTenedor5(), 1);
        Filosofo f5 = new Filosofo("[Nietzsche]", mesa.getTenedor5(), mesa.getTenedor1(), 2);

        Thread hilo1 = new Thread(f1);
        Thread hilo2 = new Thread(f2);
        Thread hilo3 = new Thread(f3);
        Thread hilo4 = new Thread(f4);
        Thread hilo5 = new Thread(f5);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}