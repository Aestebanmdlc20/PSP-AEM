/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.ejemplost1;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 13 sept 2024
 *
 */
public class LanzadorProcesos {
    
    
    public void ejecutar(String ruta){
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            Process process = pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public static void main(String[] args) {
        String ruta= "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe";
        LanzadorProcesos lp = new LanzadorProcesos();
        lp.ejecutar(ruta);
        System.out.println("Finalizado");
    }
}
