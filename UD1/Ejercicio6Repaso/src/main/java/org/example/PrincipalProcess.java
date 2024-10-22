package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrincipalProcess {

    public static void process(String directorio, String palabra) {
        List<Thread> hilos = new ArrayList<>();
        List<WordFileReader> readers = new ArrayList<>();

        File folder = new File(directorio);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                FileData fileData = new FileData(file.getAbsolutePath(), palabra);
                WordFileReader wordFileReader = new WordFileReader(fileData);
                Thread hilo = new Thread(wordFileReader);
                readers.add(wordFileReader);
                hilos.add(hilo);
                hilo.start();
            }
        }

        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        FileWriter fileOut = null;
        BufferedWriter bw = null;
        try {
            fileOut = new FileWriter(new File("resultados.txt"));
            bw = new BufferedWriter(fileOut);

            for (WordFileReader reader : readers) {
                FileData fileData = reader.getFileData();
                if (fileData.getOcurrencias() > 0) {
                    bw.write(fileData.getOcurrencias() + " ocurrencias en el fichero " + fileData.getNombreFichero() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java PrincipalProcess <directorio> <palabra>");
            return;
        }

        String directorio = args[0];
        String palabra = args[1];

        process(directorio, palabra);
    }
}