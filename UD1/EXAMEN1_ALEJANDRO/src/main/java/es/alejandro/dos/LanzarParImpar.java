package es.alejandro.dos;

public class LanzarParImpar {
    private static Secuenciador secuenciador;

    /**
     * Metodo que se encarga de lanzar los hilos
     * Una vez iniciados estos, a los 10 segundo los interrumpe
     */

    public static void lanzarParImpar(){
        secuenciador = secuenciador.getInstance(); // Intancio secuenciador (modelo Singleton)
        Thread hiloPar = new Thread(new HiloPar(secuenciador)); // Creo mi hiloPar
        Thread hiloImpar = new Thread(new HiloImpar(secuenciador)); // Creo mi hiloImpar

        // Inicio los hilos

        hiloPar.start();
        hiloImpar.start();

        try {
            Thread.sleep(10000); // A los 10 segundos se harán los interrupts para parar los hilos
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Interrumpo mis hilos
        hiloPar.interrupt();
        hiloImpar.interrupt();

    }

    public static void main(String[] args){
        lanzarParImpar();
    }
}
