package org.example;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Filosofo f1 = new Filosofo("[Platon]", mesa.getTenedor(0), mesa.getTenedor(1));
        Filosofo f2 = new Filosofo("[Descartes]", mesa.getTenedor(1), mesa.getTenedor(2));
        Filosofo f3 = new Filosofo("[Rousseau]", mesa.getTenedor(2), mesa.getTenedor(3));
        Filosofo f4 = new Filosofo("[Bertrand]", mesa.getTenedor(3), mesa.getTenedor(4));
        Filosofo f5 = new Filosofo("[Nietzsche]", mesa.getTenedor(4), mesa.getTenedor(0));

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