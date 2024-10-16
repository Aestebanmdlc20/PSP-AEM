package org.example;

public class Main {
    public static void main(String[] args) {
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