package org.example;

/**
 *
 * • Coche: Cada coche al crearse, registra su nombre y el número de metros que avanza
 * en cada iteración, el cual será un numero aleatorio entre 1 y 50 metros. Se ejecutará
 * mientras la carrera no haya terminado. Por cada iteración, le dirá a Carrera el número
 * de metros totales que lleva, y Carrera deberá comprobar si el coche en cuestión ha
 * llegado a meta y por tanto ha ganado en cuyo caso mostrará por consola un mensaje
 * del tipo “El coche XXX ha ganado la carrera ¡¡¡¡”, si por contrario no ha ganado,
 * deberá mostrarse por consola, el % de la distancia recorrida. El coche debe llevar
 * un contador interno de la distancia que lleva recorrida. Por cada vez que corre en la
 * carrera, duerme por 1 segundo.
 *
 *
 */

public class Coche implements Runnable, Comparable<Coche> {
    @Override
    public int compareTo(Coche o) {
        return Integer.compare(this.distanciaRecorrida,o.distanciaRecorrida);
    }

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
    public void run() {
        System.out.println("El coche " + nombre + " avanza " + metros + " metros cada vez");
        while (distanciaRecorrida < carrera.getDistancia()) {
            synchronized (carrera) {
                distanciaRecorrida += metros;
                carrera.setDistanciaRecorrida(distanciaRecorrida);
                int porcentaje = (int) (((double) distanciaRecorrida * 100) / carrera.getDistancia());
                System.out.println("El coche " + nombre + " ha recorrido el " + porcentaje + "% de la carrera");
                if (distanciaRecorrida >= carrera.getDistancia()) {
                    System.out.println("El coche " + nombre + " ha ganado la carrera !!!");
                } else {
                    System.out.println("El coche " + nombre + " ha recorrido el " + (distanciaRecorrida * 100) / carrera.getDistancia() + "% de la carrera");
                }
            }
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

}
