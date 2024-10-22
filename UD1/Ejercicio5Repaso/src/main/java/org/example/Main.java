package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Thread> hilos = new ArrayList<>();
        List<CuentaPalabras> cuentaPalabrasList = new ArrayList<>();

        FileReader ficheroIn = null;
        BufferedReader br = null;
        String line;
        int globalCount = 0;
        try{
            ficheroIn = new FileReader("./texto.txt");
            br = new BufferedReader(ficheroIn);

            while ((line = br.readLine())!= null){
                CuentaPalabras cuentaPalabras = new CuentaPalabras(line);
                cuentaPalabrasList.add(cuentaPalabras);
                Thread hilo = new Thread(cuentaPalabras);
                hilos.add(hilo);
                hilo.start();
            }

            for(Thread hilo:hilos){
                hilo.join();
            }

            for(CuentaPalabras cuentaPalabras:cuentaPalabrasList){
                globalCount += cuentaPalabras.getCount();
            }

            System.out.println("Total de palabras: " + globalCount);

        } catch (IOException ex){
            ex.printStackTrace();
            throw ex;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}