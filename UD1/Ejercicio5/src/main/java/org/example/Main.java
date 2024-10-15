package org.example;

public class Main {
    public static void main(String[] args) {
        String filePath = "./prueba.txt";
        Lectura lectura = new Lectura();
        lectura.leerFichero(filePath);
        int totalPalabras = lectura.contarPalabras();
        System.out.println("Número total de palabras: " + totalPalabras);
    }
}