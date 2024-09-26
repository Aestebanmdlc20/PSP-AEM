/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.creacionhilos;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 25 sept 2024
 *
 */
public class Main {
    public static void main (String[] args){
        //Implementando Runnable
        Thread t = new Thread(new CrearHiloRunnable());
        t.start();
        
        //Extendiendo de Thread
        CrearHilos hilo = new CrearHilos();
        hilo.start();
        System.out.println("");
        System.out.println("");
        
        CrearHilos h=null;
        
        for(int i=0;i<3;i++){
            h = new CrearHilos();
            h.setName("HILO"+i);
            h.setPriority(+1);
            h.start();
            System.out.println("Informacion del " + h.getName()+" : "+h.toString());
        }
    }
}
