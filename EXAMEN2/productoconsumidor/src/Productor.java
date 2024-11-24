public class Productor extends Thread{

    Cola colaCompartida;

    public Productor(Cola colaCompartida){
        this.colaCompartida = colaCompartida;
    }

    @Override
    public void run(){
        while(true){
            int num = 1 + (int)(Math.random() * 10);
            while(!colaCompartida.encolar(num)){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Productor agregó el número: " + num);
        }
    }

}
