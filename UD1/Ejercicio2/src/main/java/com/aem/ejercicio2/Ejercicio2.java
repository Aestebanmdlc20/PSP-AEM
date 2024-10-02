/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 */
public class Ejercicio2 {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "dir");
        
        try {
            Process proceso = pb.start();
            int exitCode = proceso.waitFor();
            
            if (exitCode == 0) {
                //Uso try-with-resources 
                try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                    String line = br.readLine();
                    
                    while (line != null) {
                        System.out.println(line);
                        line = br.readLine();
                    }
                }
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
