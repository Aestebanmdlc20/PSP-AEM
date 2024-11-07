package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
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
            throw e;
        }

        List<Coche> coches = new ArrayList<>();
        coches.add(opel);
        coches.add(ford);
        coches.add(seat);
        coches.sort(null);

        System.out.println("Pódium:");
        System.out.println("Oro: " + coches.get(0).getNombre() + " con " + coches.get(0).getDistanciaRecorrida() + " metros");
        System.out.println("Plata: " + coches.get(1).getNombre() + " con " + coches.get(1).getDistanciaRecorrida() + " metros");
        System.out.println("Bronce: " + coches.get(2).getNombre() + " con " + coches.get(2).getDistanciaRecorrida() + " metros");
    }
}