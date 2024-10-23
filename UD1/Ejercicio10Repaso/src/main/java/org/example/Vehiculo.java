package org.example;

public class Vehiculo implements Runnable{

    public static final int NORTE = 0;
    public static final int SUR = 1;

    private int cocheId;
    private int direccion;
    private Puente puente;

    public Vehiculo(int cocheId, int direccion, Puente puente) {
        this.cocheId = cocheId;
        this.direccion=direccion;
        this.puente = puente;
    }

    @Override
    public void run() {
        puente.cruzarPuente(this);
    }

    public int getCocheId(){
        return this.cocheId;
    }

    public int getDireccion(){
        return this.direccion;
    }

}
