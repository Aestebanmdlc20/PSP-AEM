package org.example;

public class Coche implements Runnable, Comparable<Coche> {

    private String nombre;
    private int metros;
    private Carrera carrera;
    private int distanciaRecorrida;

    public Coche(String nombre, Carrera carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.metros = (int) (Math.random() * 50) + 1;
        this.distanciaRecorrida = 0;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    @Override
    public int compareTo(Coche o) {
        return Integer.valueOf(o.getDistanciaRecorrida()).compareTo(this.getDistanciaRecorrida());
    }

    @Override
    public void run() {
        System.out.println("El coche " + nombre + " avanza " + metros + " metros cada vez");
        while (!carrera.isFinalizada()) {
            distanciaRecorrida += metros;
            carrera.avanzar(this);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getMetros() {
        return metros;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

}
