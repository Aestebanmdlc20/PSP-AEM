package org.example;

public class UsarAula {
    public static void main(String[] args) {
        Saludar saludar = new Saludar();

        Thread[] alumnos = new Thread[6];
        for (int i = 0; i < 6; i++) {
            alumnos[i] = new Thread(new Aula("Alumno " + (i + 1), saludar, false));
            alumnos[i].start();
        }

        Thread profesor = new Thread(new Aula("Profesor", saludar, true));
        profesor.start();

        try {
            for (Thread alumno : alumnos) {
                alumno.join();
            }
            profesor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}