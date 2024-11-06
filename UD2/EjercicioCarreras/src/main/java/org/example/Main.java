package org.example;


/**
 *
 * • Principal: Creará los coches que participan en la carrera. En concreto se crearán 3
 * coches con nombres: Opel, Ford y Seat.
 *
 */

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        Coche opel = new Coche("Opel", carrera);
        Coche ford = new Coche("Ford", carrera);
        Coche seat = new Coche("Seat", carrera);

        Thread hiloOpel = new Thread(opel);
        Thread hiloFord = new Thread(ford);
        Thread hiloSeat = new Thread(seat);

        hiloOpel.start();
        hiloFord.start();
        hiloSeat.start();

        try {
            hiloOpel.join();
            hiloFord.join();
            hiloSeat.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Coche[] coches = {opel, ford, seat};
        Arrays.sort(coches, Comparator.reverseOrder());

        System.out.println("Pódium:");
        System.out.println("Oro: " + coches[0].getNombre() + " con " + coches[0].getDistanciaRecorrida() + " metros");
        System.out.println("Plata: " + coches[1].getNombre() + " con " + coches[1].getDistanciaRecorrida() + " metros");
        System.out.println("Bronce: " + coches[2].getNombre() + " con " + coches[2].getDistanciaRecorrida() + " metros");
    }
}