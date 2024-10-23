package org.example;

import java.io.File;
import java.util.List;

public class PrincipalProcess {


    public static void lanzarHilo(String directorio, String palabraABuscar){

        List<WordFileReader> listaReaders;
        List<Thread> listaThreads<

        File directory = new File(directorio);

        if (directory.isDirectory()){
            File[] files = directory.listFiles();
            for( File file:files){
                if(file.isFile()){
                    FileData fileData = new FileData(file.getAbsolutePath(),palabraABuscar);
                    WordFileReader reader
                }
            }
        }

    }

    public static void main(String[] args) {

        String directorio = args[0];
        String palabraABuscar = args[1];

        lanzarHilo(directorio, palabraABuscar);
    }
}