/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.ejemplost1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 13 sept 2024
 *
 */
public class Lanzador {
    
    public static void main(String[] args) throws IOException{
        Lanzador l = new Lanzador();
        l.lanzarSumador(1, 51);
        l.lanzarSumador(51, 100);
    }
    
    public void lanzarSumador(int n1, int n2) throws IOException{
       String clase="com.aem.ejemplost1.Sumador";
       ProcessBuilder pb;
       Process process = null;
       try {
           pb = new ProcessBuilder("java", clase, String.valueOf(n1), String.valueOf(n2));
           
           //Con esto redirecciono el error
           pb.redirectError(new File("Files" + File.separator + "error.log"));
           
           //Cambia el directorio de trabajo, al directorio donde se encuentran los .class
           pb.directory(new File("target" + File.separator + "classes"));
           
           process=pb.start();
           
           //el proceso padre, espera a que el proceso hijo termine
           //pb.directory(new File("bin")
           
           int exitValue = process.waitFor();
           System.out.println("Exit value: " + exitValue);
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       //Mostrar datos generados por Sumador
       
       try (InputStream is = process.getInputStream()) {
           int c;
           while ((c = is.read()) != -1){
               System.out.print((char) c);
           }
       } catch(IOException e){
           e.printStackTrace();
           throw e;
       }
    }
 
}

