package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lectura {

    private ArrayList<HiloCuentaPalabras> hilos = new ArrayList<>();

    public void leerFichero(String fichero) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            String linea;
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                HiloCuentaPalabras hilo = new HiloCuentaPalabras(linea);
                hilos.add(hilo);
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int contarPalabras() {
        int totalPalabras = 0;
        for (HiloCuentaPalabras hilo : hilos) {
            try {
                hilo.join();
                totalPalabras += hilo.getContadorPalabras();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPalabras;
    }
}