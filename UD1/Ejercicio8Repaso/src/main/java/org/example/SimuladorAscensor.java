package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SimuladorAscensor {

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor(1,10);
        Usuario u1 = new Usuario(3,ascensor);
        Usuario u2 = new Usuario(7,ascensor);
        Usuario u3 = new Usuario(4,ascensor);

        Thread h1 = new Thread(u1);
        Thread h2 = new Thread(u2);
        Thread h3 = new Thread(u3);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}