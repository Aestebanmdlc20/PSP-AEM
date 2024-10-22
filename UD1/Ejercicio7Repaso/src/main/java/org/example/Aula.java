package org.example;

public class Aula implements Runnable {
    private String nombre;
    private Saludar saludar;
    private boolean esProfesor;

    public Aula(String nombre, Saludar saludar, boolean esProfesor) {
        this.nombre = nombre;
        this.saludar = saludar;
        this.esProfesor = esProfesor;
    }

    @Override
    public void run() {
        if (esProfesor) {
            saludar.responderSaludo();
        } else {
            saludar.saludarProfe(nombre);
        }
    }
}