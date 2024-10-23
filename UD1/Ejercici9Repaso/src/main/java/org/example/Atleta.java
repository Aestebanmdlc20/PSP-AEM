package org.example;

public class Atleta implements Runnable{

    private int dorsal;
    Testigo testigo;

    public Atleta(int dorsal, Testigo testigo) {
        this.dorsal = dorsal;
        this.testigo = testigo;
    }

    @Override
    public void run() {
        testigo.esperarTurno(this.dorsal);
        long tiempoInicio = System.currentTimeMillis();

        int tiempoCarrera = (int)(9000 + Math.random() * 2000);
        System.out.println("Atleta " + dorsal + " está corriendo durante " + (tiempoCarrera / 1000) + " segundos.");

        try {
            Thread.sleep(tiempoCarrera);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long tiempoFin = System.currentTimeMillis();
        System.out.println("Atleta " + dorsal + " terminó de correr. Tiempo total: " + ((tiempoFin - tiempoInicio) / 1000) + " segundos.");
        testigo.pasarTestigo(this.dorsal);
    }
}
