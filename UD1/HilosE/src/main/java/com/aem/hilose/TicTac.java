/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.hilose;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 9 oct 2024
 *
 */
public class TicTac {
    public synchronized void esperar() throws InterruptedException {
        wait();
    }

    public synchronized void avisar() throws InterruptedException {
        notifyAll();
    }
}
