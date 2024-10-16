package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordFileReader implements Runnable {
    private String rutaArchivo;
    private String palabra;
    private FileData datosArchivo;

    public WordFileReader(String rutaArchivo, String palabra) {
        this.rutaArchivo = rutaArchivo;
        this.palabra = palabra;
        this.datosArchivo = new FileData(rutaArchivo, palabra);
    }

    @Override
    public void run() {
        FileReader fileReader = null;
        BufferedReader lector = null;
        try {
            fileReader = new FileReader(rutaArchivo);
            lector = new BufferedReader(fileReader);
            String linea;
            int numeroLinea = 0;
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                String[] palabras = linea.split(" ");
                for (String palabraActual : palabras) {
                    palabraActual = palabraActual.replaceAll("[^a-zA-Z0-9]", ""); // Elimina caracteres no alfanuméricos
                    if (!palabraActual.isEmpty() && palabraActual.equalsIgnoreCase(palabra)) {
                        datosArchivo.agregarOcurrencia(numeroLinea, linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FileData getDatosArchivo() {
        return datosArchivo;
    }
}