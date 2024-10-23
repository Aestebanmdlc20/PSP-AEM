package org.example;

public class Puente {
    // Siguiendo el modelo Singleton
    // Crear referencia como estatica
    private static Puente instance = null;

    // Constructori privado
    private Puente(){

    }

    // Metodos del modelo Singleton
    private synchronized static void createInstance(){
        if (instance == null){
            instance = new Puente();
        }
    }

    public static Puente getInstance(){
        if (instance == null){
            createInstance();
        }
        return instance;
    }

    // Otros metodos

    public synchronized void cruzarPuente(Vehiculo vehiculo){
        String direccion;
        if(vehiculo.getDireccion() == Vehiculo.NORTE){
            direccion = "norte";
        } else {
            direccion = "sur";
        }
        System.out.println("El vehículo " + vehiculo.getCocheId() + " está cruzando el puente desde el " + direccion + ".");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("El vehículo " + vehiculo.getCocheId() + " ha salido del puente.");
    }

}
