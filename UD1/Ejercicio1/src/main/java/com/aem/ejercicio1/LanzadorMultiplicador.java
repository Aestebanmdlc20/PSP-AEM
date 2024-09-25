/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.ejercicio1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 19 sept 2024
 *
 */
public class LanzadorMultiplicador {
    
    
    public void lanzarMultiplicador(int num1, int num2, String fSalida) throws IOException{
        
        String clase="com.aem.ejercicio1.Multiplicador";
        ProcessBuilder pb;
        Process process = null;
        int exitValue=0;
        
        try{
            String classPath = ".;.taget/classes";
            
            pb=new ProcessBuilder("java","-cp",classPath,clase,String.valueOf(num1),String.valueOf(num2));
            
            pb.redirectError(new File("Files"+File.separator+"error_"+fSalida+System.currentTimeMillis())); //Error
            
            pb.redirectOutput(new File("Files" + File.separator + fSalida+".log"));
            
            process=pb.start();
            exitValue=process.waitFor();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
