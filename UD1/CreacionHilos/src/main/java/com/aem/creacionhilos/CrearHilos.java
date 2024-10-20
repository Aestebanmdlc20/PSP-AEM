/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.creacionhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 25 sept 2024
 *
 */
public class CrearHilos extends Thread { //Extiende de Thread
    /**
     * El hilo ejecuta lo que ponga dentro del metodo run
     * No devuelve nada ni admite parametros
     * Si quiero algun parametro se lo tengo que pasar por el constructor de la clase
     */
    
   @Override
   public void run(){ 
       try {
           //Acciones que lleva  acabo un hilo
           System.out.println("\n Hola soy el:" + Thread.currentThread().getName()
                   + "\n Prioridad: " + Thread.currentThread().getPriority()
                   + "\n ID: " + Thread.currentThread().getPriority()
                   + "\n Hilos activos: " + Thread.currentThread().activeCount());
           Thread.currentThread().sleep(1000);
       } catch (InterruptedException ex) {
           Logger.getLogger(CrearHilos.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
