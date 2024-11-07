package org.example;

public class Carrera {
    private int distancia;
    private boolean finalizada;

    public Carrera() {
        this.distancia = (int) (Math.random() * 1000) + 1;
        finalizada = false;
    }

    public int getDistancia() {
        return distancia;
    }

    public synchronized boolean isFinalizada() {
        return finalizada;
    }

    public synchronized void avanzar(Coche coche){
        int porcentaje = (int) (((double) coche.getDistanciaRecorrida() * 100) / this.distancia);
        System.out.println("El coche " + coche.getNombre() + " ha recorrido el " + porcentaje + "% de la carrera");
        if (coche.getDistanciaRecorrida() >= this.distancia) {
            System.out.println("El coche " + coche.getNombre() + " ha ganado la carrera !!!");
            this.finalizada = true;
        }
    }
}