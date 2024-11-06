package org.example;


/**
 * • Carrera: Al crearse, se calculará la distancia que hay que recorrer para ganar la
 * carrera, siendo un número aleatorio entre 1 y 1000 metros. La carrera termina
 * cuando un coche llegue a la meta.
 *
 */

public class Carrera {
    private int distancia;
    private int distanciaRecorrida;

    public Carrera() {
        this.distancia = (int) Math.random()*1000 + 1;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
    this.distancia = distancia;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

}