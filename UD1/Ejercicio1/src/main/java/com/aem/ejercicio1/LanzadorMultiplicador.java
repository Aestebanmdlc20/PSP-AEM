/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 19 sept 2024
 *
 */
public class LanzadorMultiplicador {
    
    public static void main (String[] args){
        LanzadorMultiplicador l = new LanzadorMultiplicador();
        try {
            l.lanzarMultiplicador(4, 5, "Ejemplo1");
            l.lanzarMultiplicador(4, 5, "Ejemplo1");
        } catch (IOException ex) {
            Logger.getLogger(LanzadorMultiplicador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void lanzarMultiplicador(int num1, int num2, String fSalida) throws IOException{
        
        String clase="com.aem.ejercicio1.Multiplicador";
        ProcessBuilder pb;
        Process proceso = null;
        int exitValue=0;
        
        try{
            String classPath = ".;./target/classes";
            
            pb=new ProcessBuilder("java","-cp",classPath,clase,String.valueOf(num1),String.valueOf(num2));
            
            pb.redirectError(new File("Files"+File.separator+"error_"+fSalida+System.currentTimeMillis())); //Error
            
            pb.redirectOutput(new File("Files" + File.separator + fSalida+".log"));
            
            proceso=pb.start();
            exitValue=proceso.waitFor();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
