package org.example;

public class HiloCuentaPalabras extends Thread {
    private String linea;
    private int contadorPalabras;

    public HiloCuentaPalabras(String linea) {
        this.linea = linea;
        this.contadorPalabras = 0;
    }

    @Override
    public void run() {
        String[] palabras = linea.split("\\s+");
        contadorPalabras = palabras.length;
    }

    public int getContadorPalabras() {
        return contadorPalabras;
    }
}