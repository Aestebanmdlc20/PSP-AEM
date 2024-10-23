package org.example;

public class Testigo {

    private int turnoActual =1;

    public synchronized void esperarTurno(int dorsal){
        while(dorsal!=this.turnoActual){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public synchronized void pasarTestigo(int dorsal){
        this.turnoActual =dorsal+1;
        if(this.turnoActual > 4){
            System.out.println("Carrera finalizada!");
        } else{
            System.out.println("Atleta " + dorsal + " ha pasado el testigo al Atleta " + this.turnoActual + ".");
            notifyAll();
        }
    }

}
