package org.example;

public class Saludar {

    public synchronized void saludarProfe(String nombreAlumno) {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(nombreAlumno + " -> Buenos días Profesor");
    }

    public synchronized void responderSaludo() {
        System.out.println("Profesor -> Buenos días");
        this.notifyAll();
    }
}