public class Conusmidor extends Thread{
    Cola colaCompartida;

    public Conusmidor(Cola colaCompartida){
        this.colaCompartida = colaCompartida;
    }

    @Override
    public void run(){
        while(true){
            if(!colaCompartida.desencolar()){
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


}
