package org.example;

import java.io.*;

public class ContarVocal {

    public void contarVocal(String fichero, char vocal){
        int contador = 0;
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                for(int i = 0; i < linea.length(); i++){
                    if(linea.charAt(i) == vocal){
                        contador++;
                    }
                }
            }
            System.out.println(contador);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ContarVocal contarVocal = new ContarVocal();
        String fichero = args[0];
        char vocal = args[1].charAt(0);
        contarVocal.contarVocal(fichero, vocal);

    }
}
