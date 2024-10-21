package org.example;

import java.io.File;
import java.io.IOException;

public class LanzadorMultiplicador {
    public static void lanzarMultiplicador(int a,int b, String nombreFicheroSalida){

        String clase = "org.example.Multiplicador";
        ProcessBuilder pb = null;
        Process proceso = null;
        int exitVal = 0;
        String classPath = ".;./target/classes";
        pb = new ProcessBuilder("java", "-cp", classPath, clase, String.valueOf(a), String.valueOf(b));
        pb.redirectOutput(new File("Files"+File.separator+nombreFicheroSalida+".log"));
        pb.redirectError(new File("Files"+File.separator+"error_"+System.currentTimeMillis()+".txt"));
        try {
            proceso = pb.start();
            exitVal = proceso.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        LanzadorMultiplicador l1 = new LanzadorMultiplicador();

        l1.lanzarMultiplicador(2, 3, "fichero1");
        l1.lanzarMultiplicador(3, 4, "fichero2");
    }

}
