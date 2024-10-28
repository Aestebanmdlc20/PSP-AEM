package org.example;

import java.io.*;

public class LanzadorCuentaCantidades {

    public static void lanzarCuentaCantidades() throws IOException {

        // Strings de clase y ruta
        String clase = "org.example.CuentaCantidades";
        String classPath = ".;./target/classes";

        int contadorGlobal = 0;
        int exitValue = 0;
        ProcessBuilder pb = null;
        Process proceso = null;

        String[] ficheros = {"./informatica.txt", "./administracion.txt", "./eso.txt", "./bachillerato.txt", "./comercio.txt"};

        for (String fichero : ficheros) { // Iniciar procesos hijos
            pb = new ProcessBuilder("java", "-cp", classPath, clase, fichero);
            //pb.redirectOutput(new File(".\\FilesGen\\" + fichero + ".res"));
            pb.redirectError(new File("errores.txt"));
            proceso = pb.start();
            try {
                exitValue = proceso.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (String fichero : ficheros) { // Leer resultados de los ficheros
            try (FileReader ficheroIn = new FileReader(new File(".\\FilesGen\\" + fichero + ".res"));
                 BufferedReader br = new BufferedReader(ficheroIn)) {

                String linea;
                while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                    contadorGlobal += Integer.parseInt(linea);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }

        try (FileWriter ficheroOut = new FileWriter(new File(".\\resultado_final.txt"));
             BufferedWriter bw = new BufferedWriter(ficheroOut)) {
            bw.write("El total de alumnos es: " + contadorGlobal);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public static void main(String[] args) throws IOException {
        lanzarCuentaCantidades();
    }
}

