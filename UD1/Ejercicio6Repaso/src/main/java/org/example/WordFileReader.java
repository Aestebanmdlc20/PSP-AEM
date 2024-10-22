package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordFileReader implements Runnable{
    private FileData fileData;
    public WordFileReader(FileData fileData){
        this.fileData = fileData;
    }

    @Override
    public void run() {
        FileReader fileIn = null;
        BufferedReader reader = null;
        String line;
        try{

            fileIn = new FileReader(this.fileData.getNombreFichero());
            reader = new BufferedReader(fileIn);
            int lineNumber=1;
            while((line = reader.readLine()) != null){
                String[] linea = line.split(" ");
                for(String palabra:linea){
                    if(palabra.replaceAll("[^a-zA-Z0-9]","").equals(this.fileData.getPalabra().replaceAll("[^a-zA-Z0-9]",""))){
                        fileData.setOcurrencias(fileData.getOcurrencias()+1);
                        fileData.addLineNumber(lineNumber);
                        fileData.addLine(line);
                    }
                }
                lineNumber++;
            }

        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try {
                if (fileIn != null) {
                    fileIn.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getOcurrencias(){
        return this.fileData.getOcurrencias();
    }

    public FileData getFileData(){
        return this.fileData;
    }

}
