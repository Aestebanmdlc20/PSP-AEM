package es.alejandro.dos;

public class LanzarParImpar {

    /**
     * Metodo que se encarga de lanzar los hilos
     * Una vez iniciados estos, a los 10 segundo los interrumpe
     */

    public static void lanzarParImpar(){
        Thread hiloPar = new Thread(new HiloPar()); // Creo mi hiloPar
        Thread hiloImpar = new Thread(new HiloImpar()); // Creo mi hiloImpar

        // Inicio los hilos

        hiloPar.start();
        hiloImpar.start();

        for (int i = 0; i < 10; i++) {
            try {
                Secuenciador.getInstance().siguiente();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Hilo interrumpido");
            }
        }

        //Interrumpo mis hilos
        hiloPar.interrupt();
        hiloImpar.interrupt();

    }

    public static void main(String[] args){
        lanzarParImpar();
    }
}
