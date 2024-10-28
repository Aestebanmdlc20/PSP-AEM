package es.alejandro.uno;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    /**
     * Metodo que se encarga de lanzar el proceso "Minimo"
     *
     * @param num1 Primer numero entero a pasar por argumento al proceso "minimo"
     * @param num2 Segundo numero entero a pasar por argumento al proceso "minimo"
     *
     * Redirige la salida a ./files/minimo_alejandro.txt
     * Redirige la salida de error a ./files/error_alejandro.txt
     */

    public static void lanzarMinimo(int num1, int num2){

        // String para el classPath y class
        String classPath=".;./target/classes";
        String clase = "es.alejandro.uno.Minimo";

        ProcessBuilder pb = null;
        Process minimo = null;
        int exitValue = 0;
        try{

            pb = new ProcessBuilder("java","-cp",classPath,clase,String.valueOf(num1),String.valueOf(num2));
            pb.redirectError(new File("./files/error_alejandro.txt"));
            pb.redirectOutput(new File("./files/minimo_alejandro.txt"));
            minimo = pb.start();
            exitValue = minimo.waitFor();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Ejecuta el metodo lanzarMinimo(int num1, int num2)
     *
     * @param args numeros que se van a pasar al metodo lanzarMinimo
     */

    public static void main(String[] args){
        if(args.length < 2){
            throw new IllegalArgumentException("Hay menos de dos argumentos!");
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        lanzarMinimo(num1,num2);

    }

}
