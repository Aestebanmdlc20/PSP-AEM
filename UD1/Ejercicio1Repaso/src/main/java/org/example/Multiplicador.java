package org.example;

public class Multiplicador {

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static void main(String[] args){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int resultado=multiplicar(num1, num2);
        System.out.println("Resultado de "+num1+"x"+num2+" = "+resultado);
    }
}
