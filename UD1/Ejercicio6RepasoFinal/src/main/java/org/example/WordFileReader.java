package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordFileReader implements Runnable{

    private FileData fileData;

    public WordFileReader(FileData fileData) {
        this.fileData = fileData;
    }

    @Override
    public void run() {
        FileReader ficheroIn = null;
        BufferedReader bufferIn = null;
        String linea;
        String[] palabras;
        int lineNumber=1;
        try{

            ficheroIn = new FileReader(fileData.getFichero());
            bufferIn = new BufferedReader(ficheroIn);

            while ((linea = bufferIn.readLine()) != null){
                palabras = linea.replaceAll("[^a-zA-z0-9]", "").split(" ");
                for (String palabra:palabras){
                    if(palabra.equalsIgnoreCase(fileData.getPalabraBuscada()));
                    fileData.setNumeroOcurrencias(fileData.getNumeroOcurrencias()+1);
                    fileData.setNumLinea(lineNumber);
                    fileData.setContenidoLinea(linea);
                }
                lineNumber++;
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public FileData getFileData(){
        return this.fileData;
    }

}
