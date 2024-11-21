package org.example;

public class Ring {
    private static Object object = new Object();
    private int numCombates;

    public int getNumCombates() {
        synchronized (object) {
            return numCombates;
        }
    }

    public void competir(Boxeador boxeador1, Boxeador boxeador2){

        boxeador1.pegar();
        boxeador2.recibir();

        synchronized (object) {
            numCombates++;
        }

        System.out.println("El boxeador " + boxeador1.getNombre() + " ha pegado al boxeador " + boxeador2.getNombre());
    }

}
