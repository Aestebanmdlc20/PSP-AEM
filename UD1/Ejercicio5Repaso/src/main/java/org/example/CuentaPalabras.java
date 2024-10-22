package org.example;

public class CuentaPalabras implements Runnable {
    private String line;
    private int count;

    public CuentaPalabras(String line) {
        this.line = line;
    }

    public int getCount() {
        return count;
    }

    private void contarPalabras() {
        String[] words = line.split(" ");
        this.count = words.length;
    }

    @Override
    public void run() {
        contarPalabras();
    }
}