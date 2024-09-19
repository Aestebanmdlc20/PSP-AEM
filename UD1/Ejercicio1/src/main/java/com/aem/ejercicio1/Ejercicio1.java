/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.ejercicio1;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        /**
         * PSP - T1 - Ejercicio 1
        1) En el paquete com.psp crear una clase Multiplicador, con método multiplicar que devuelva el resultado de
        multiplicar dos números pasados como parámetro. 
        Además se deberá crear un método main que reciba como argumento dos números y con dichos números llame al método de multiplicar. 
        Una vez obtenido el resultado, desde el método main se debe mostrar por pantalla el resultado de la multiplicación.
        
        2) Escribir un programa Java que tendrá la misión de ser un "Creador de procesos", al que 1lamaremos
        LanzadorMultiplicador.
        El método lanzarMultiplicador, tendrá como parámetros de entrada los dos números que se van a multiplicar, asi como un
        tercer parámetro con el nombre del fichero de salida.
        El programa java, (proceso padre), tendrá un método 1lamado LanzarMultiplicador, el cual con la clase ProcessBuilder
        ejecutará la clase java com.psp.Multiplicador.
        Recuerda especificar el classpath cuando llames al proceso Java.
        También se debe redirigir la salida de error estándar a un fichero error.log (añádele al nombre del fichero
        System. currentTimeMillis() para que cada vez que se ejecute se genere un fichero diferente.
        Redirige la salida estándar a un fichero cuyo nombre será el indicado por parámetro.
        Ambos ficheros deberán generarse en el directorio files del proyecto.
        Comprueba también si el proceso ha terminado o no correctamente, en el caso que termine correctamente muestra por
        consola el contenido del fichero al que se redirigió la salida estándar.
        Crear en la clase LanzadorMultiplicador, un método main desde donde se pedirá multiplicar dos números.
         * 
         */
        Multiplicador m = new Multiplicador();
        System.out.println(m.multiplicar(2, 3));
    }
}
