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
        l.lanzarSumador(1, 51, "sumador1");
        l.lanzarSumador(51, 100, "sumador2");
    }
    
    public void lanzarSumador(int n1, int n2, String fsalida) throws IOException{
       String clase="com.aem.ejemplost1.Sumador";
       ProcessBuilder pb;
       Process process = null;
       int exitValue=0;
       
       try {
           String classPath = ".;./target/classes"; //directorio donde tenemos las clases
           
           pb = new ProcessBuilder("java", "-cp", classPath, clase, String.valueOf(n1), String.valueOf(n2));
           
           //Con esto redirecciono el error
           pb.redirectError(new File("Files" + File.separator + "error_" + fsalida + System.currentTimeMillis()+".log"));
           
           //Escrbir datos generados por sumador en un fichero
           pb.redirectOutput(new File("Files" + File.separator + fsalida+".log"));
           
           //Cambia el directorio de trabajo, al directorio donde se encuentran los .class
           //pb.directory(new File("target" + File.separator + "classes"));
           
           process=pb.start(); //el proceso padre, espera a que el proceso hijo termine
           
           exitValue = process.waitFor(); //Hago esperar a mi programa principal hasta que el process termine
           
           System.out.println("Exit value: " + exitValue);
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       //Mostrar datos generados por Sumador en la consola
       
       if(exitValue==0){
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
}

