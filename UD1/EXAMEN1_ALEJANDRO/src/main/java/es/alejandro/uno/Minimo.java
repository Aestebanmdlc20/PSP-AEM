package es.alejandro.uno;

public class Minimo {

    /**
     * Metodo que indica en consola el menor de dos numero enteros pasados por parametro
     *
     * @param num1 Primer numero entero a comparar
     * @param num2 Segundo numero entero a comparar
     */

    public void calcularMinimo(int num1, int num2){
        if(num1 < num2){
            System.out.println("El numero: " + num1 +" es menor que el numero: " + num2);
        } else if(num1 > num2) {
            System.out.println("El numero: " + num2 +" es menor que el numero: " + num1);
        } else{
            System.out.println("El :numero " + num1 + " es igual que el numero: " + num2);
        }
    }

    /**
     * Ejecuta el metodo calcularMinimo(int num1, int num2)
     *
     * @param args numeros que se van a pasar al metodo calcularMinimo
     */
    public static void main (String[] args){
        if(args.length != 2){
            throw new IllegalArgumentException("Hay menos de dos argumentos!");
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        Minimo minimo = new Minimo();
        minimo.calcularMinimo(num1,num2);

    }

}
