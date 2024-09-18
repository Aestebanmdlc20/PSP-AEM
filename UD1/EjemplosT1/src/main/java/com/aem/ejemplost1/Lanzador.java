/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.ejemplost1;

import java.io.File;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 13 sept 2024
 *
 */
public class Lanzador {
 public void lanzarSumador(int n1, int n2){
    String clase="Sumador";
    ProcessBuilder pb;
    try {
        pb = new ProcessBuilder("java", clase, String.valueOf(n1), String.valueOf(n2));
        pb.redirectError(new File("Files" + File.separator + "error.log"));
        pb.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
 }
 
 public static void main(String[] args){
    Lanzador l=new Lanzador();
    l.lanzarSumador(1, 51);
    l.lanzarSumador(51, 100);
 }
}

