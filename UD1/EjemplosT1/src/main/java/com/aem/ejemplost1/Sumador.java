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
public class Sumador {
 public static int sumar(int n1, int n2){
    return (n1 + n2);
 }
 
 public static void main(String[] args){
    int n1=Integer.parseInt(args[0]);
    int n2=Integer.parseInt(args[1]);
    int suma= Sumador.sumar(n1, n2);
    System.out.println(suma);
 }
}

