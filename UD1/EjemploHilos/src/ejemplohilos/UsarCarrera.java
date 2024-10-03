/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ejemplohilos;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 3 oct 2024
 *
 */
public class UsarCarrera {
    public static void main (String[] args) throws InterruptedException{
        Carrera conejo = new Carrera(1,"conejo");
        Carrera liebre = new Carrera(4,"liebre");
        Carrera tortuga = new Carrera(8,"tortuga");

        conejo.start();
        liebre.start();
        tortuga.start();
        
        conejo.join();
        liebre.join();
        tortuga.join();
    }
}
