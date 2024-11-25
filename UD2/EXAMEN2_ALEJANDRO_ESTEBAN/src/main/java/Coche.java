public class Coche extends Thread{
    private Parking parking;

    public Coche(String name, Parking parking){
        this.setName(name);
        this.parking = parking;
    }

    @Override
    public void run(){
        while(!this.isInterrupted()){
            try{
                int randomTime = 1000 * ((int) (Math.random() * 3) +1); // Tiempo random entre 1 y 3 segundos
                parking.entrar(this);
                Thread.currentThread().sleep(randomTime);
                parking.salir(this);
            } catch(InterruptedException ex){
                this.interrupt();
            }
        }
    }

}
