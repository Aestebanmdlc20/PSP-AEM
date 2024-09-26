/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.creacionhilos;

import java.util.ArrayList;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 25 sept 2024
 *
 */
public class Main {
    public static void main (String[] args) throws InterruptedException{
        //Implementando Runnable
        Thread t = new Thread(new CrearHiloRunnable());
        //t.start();
        
        //Extendiendo de Thread
        //CrearHilos hilo = new CrearHilos();
        //hilo.start();
        System.out.println("");
        System.out.println("");
        
        ArrayList<CrearHilos> listaH = new ArrayList<>();
        for(int i=0;i<5;i++){
            CrearHilos h = new CrearHilos();
            h.setName(" Hilo"+i);
            h.setPriority(generaNumeroAleatorio(1,8));
            h.start();
            listaH.add(h);            
        }
        
        for (CrearHilos hilo : listaH) {
            try {
                hilo.join(); // Espera a que cada hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
        System.out.println("Todos los hilos han terminado!");
    }
    
    public static int generaNumeroAleatorio(int minimo, int maximo){
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
}
