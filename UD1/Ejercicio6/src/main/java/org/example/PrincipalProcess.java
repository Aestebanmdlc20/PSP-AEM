package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrincipalProcess {
    private String rutaDirectorio;
    private String palabra;

    public PrincipalProcess(String rutaDirectorio, String palabra) {
        this.rutaDirectorio = rutaDirectorio;
        this.palabra = palabra;
    }

    public void procesarArchivos() throws IOException {
        File directorio = new File(rutaDirectorio);
        File[] archivos = directorio.listFiles((dir, nombre) -> nombre.endsWith(".txt")); // Con la expresion lambda verifico que solo liste archivos .txt y me ahorra codigo
        if (archivos == null) {
            System.out.println("No se encontraron archivos .txt en el directorio especificado.");
            return;
        }

        List<Thread> hilos = new ArrayList<>();
        List<WordFileReader> lectores = new ArrayList<>();

        for (File archivo : archivos) {
            WordFileReader lector = new WordFileReader(archivo.getAbsolutePath(), palabra);
            Thread hilo = new Thread(lector);
            hilos.add(hilo);
            lectores.add(lector);
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Escribimos los resultados en el archivo resultado_busqueda.txt
        BufferedWriter escritor = null;
        FileWriter fileWriter = null;
        try  {
            fileWriter = new FileWriter("resultado_busqueda.txt");
            escritor = new BufferedWriter(fileWriter);
            for (WordFileReader lector : lectores) {
                FileData datosArchivo = lector.getDatosArchivo();
                if (datosArchivo.getNumeroOcurrencias() > 0) {
                    escritor.write(datosArchivo.getNumeroOcurrencias() + " ocurrencias en el fichero " + datosArchivo.getNombreArchivo() + "\n");
                }
            }
        } catch (IOException e) {
             e.printStackTrace();
             throw e;
        } finally {
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Uso: java Main <directorio> <palabra>");
            return;
        }

        String rutaDirectorio = args[0];
        String palabra = args[1];

        PrincipalProcess proceso = new PrincipalProcess(rutaDirectorio, palabra);
        proceso.procesarArchivos();
    }
}