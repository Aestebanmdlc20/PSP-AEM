public class Barbero extends Thread{
    private GestorSillas gestorSillas;
    boolean barberoAbierta = true;
    public Barbero(GestorSillas gestorSillas, int numBarbero){
        this.gestorSillas = gestorSillas;
        barberoAbierta = true;
        this.setName("Barbero " + numBarbero);
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            try{
                this.gestorSillas.atenderCliente(this.getName());
            } catch (InterruptedException ex){
                this.interrupt();
            }
        }
    }

}
