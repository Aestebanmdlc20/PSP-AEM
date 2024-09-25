/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.creacionhilos;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 */
public class CrearHiloRunnable implements Runnable {
    
    /**
     * El hilo ejecuta lo que ponga dentro del metodo run
     * No devuelve nada ni admite parametros
     * Si quiero algun parametro se lo tengo que pasar por el constructor de la clase
     */
    
   @Override
   public void run(){ 
       //Acciones que lleva  acabo un hilo
       System.out.println("Hola soy" + Thread.currentThread().getName() 
       + "\n Prioridad: " + Thread.currentThread().getPriority() 
       + "\n ID: " + Thread.currentThread().getPriority()
       + "\n Hilos activos: " + Thread.currentThread().activeCount());
   }
}
