package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Puente puente = Puente.getInstance();

        Thread v1 = new Thread(new Vehiculo(1,Vehiculo.NORTE,puente));
        Thread v2 = new Thread(new Vehiculo(2,Vehiculo.NORTE,puente));
        Thread v3 = new Thread(new Vehiculo(3,Vehiculo.NORTE,puente));
        Thread v4 = new Thread(new Vehiculo(4,Vehiculo.SUR,puente));

        List<Thread> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(v1);
        listaVehiculos.add(v2);
        listaVehiculos.add(v3);
        listaVehiculos.add(v4);

        for(Thread h: listaVehiculos){
            h.start();
        }

    }
}