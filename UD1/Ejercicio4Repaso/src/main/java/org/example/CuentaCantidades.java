package org.example;

import java.io.*;

public class CuentaCantidades {

    public static void contarCantidades(String fichero) throws IOException {
        int contador = 0;

        try (FileReader ficheroIn = new FileReader(new File(fichero));
             BufferedReader br = new BufferedReader(ficheroIn)) {

            String linea;
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                contador += Integer.parseInt(linea);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }

        try (FileWriter ficheroOut = new FileWriter(new File(".\\FilesGen\\" + fichero + ".res"));
             BufferedWriter bw = new BufferedWriter(ficheroOut)) {
            bw.write(String.valueOf(contador));
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Uso: java CuentaCantidades <fichero>");
            System.exit(1);
        }
        contarCantidades(args[0]);
    }
}