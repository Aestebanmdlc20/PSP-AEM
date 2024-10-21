package org.example;

import java.io.*;

public class lanzarContarVocal {

    public void lanzarContarVocal() {
        String classPath = ".;./target/classes";
        String clase = "org.example.ContarVocal";
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        ProcessBuilder pb;
        Process proceso;
        int exitValue;
        int totalVocales = 0;

        for (char vocal : vocales) {
            pb = new ProcessBuilder("java", "-cp", classPath, clase, "fichero.txt", String.valueOf(vocal));
            pb.redirectError(new File("Files", "errores_" + vocal + ".txt"));
            pb.redirectOutput(new File("Files", "salida_" + vocal + ".txt"));
            try {
                proceso = pb.start();
                exitValue = proceso.waitFor();
                System.out.println("Proceso para vocal " + vocal + " terminó con código: " + exitValue);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Leer los resultados de los archivos de salida y sumar los subtotales
        for (char vocal : vocales) {
            File file = new File("Files", "salida_" + vocal + ".txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    totalVocales += Integer.parseInt(line.trim());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("El total de vocales es: " + totalVocales);
    }

    public static void main(String[] args) {
        lanzarContarVocal main = new lanzarContarVocal();
        main.lanzarContarVocal();
    }
}