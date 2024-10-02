/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 */
public class Ejercicio3 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String nombreFichero = args[0];
        char vocal = args[1].charAt(0);
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))){
            System.out.println(nombreFichero);
            int char = br.read();
        }
    }
    
}
