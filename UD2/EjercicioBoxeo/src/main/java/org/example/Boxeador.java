package org.example;

public class Boxeador implements Runnable {
    private Ring ring;
    String nombre;
    private boolean booNoqueado;
    private int golpesDados;
    private int golpesRecibidosTotales;
    private Boxeador rival;
    private int golpesNoqueo;

    public Boxeador(String nombre, Ring ring){
        this.nombre=nombre;
        this.ring = ring;
        this.booNoqueado = false;
        this.golpesDados = 0;
        this.golpesRecibidosTotales = 0;
    }

    public void setRival(Boxeador rival){
        this.rival = rival;
        System.out.println("El boxeador " + this.getNombre() + " tiene como rival a " + rival.getNombre());
    }

    public int getGolpesDados(){
        return golpesDados;
    }

    public void pegar(){
        golpesDados++;
    }

    public void recibir(){
        golpesRecibidosTotales++;
        if(this.golpesNoqueo == 3){
            booNoqueado = true;
            this.golpesNoqueo=0;
        }
        else{
            this.golpesNoqueo++;
        }
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public void run() {
        while (ring.getNumCombates() <100){
            if(booNoqueado){
                System.out.println("-- " + this.nombre + " ha sido noqueado");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){}
                booNoqueado = false;
            }
            else{
                ring.competir(this, this.rival);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){}

            }
        }
    }

    @Override
    public String toString(){
        return "Boxeador{" + "nombre=" + nombre + ", golpesDados=" + golpesDados + ", golpesRecibidosTotales=" + golpesRecibidosTotales + '}';
    }

}



