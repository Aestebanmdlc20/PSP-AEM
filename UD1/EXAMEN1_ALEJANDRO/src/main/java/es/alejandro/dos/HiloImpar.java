package es.alejandro.dos;

public class HiloImpar implements Runnable{
    Secuenciador secuenciador;

    public HiloImpar(Secuenciador secuenciador) {
        this.secuenciador = secuenciador;
    }

    /**
     * Metodo run que se encarga de cambiar el estado del hilo
     * Espera a ser notificado para incrementar el contador
     * Una vez los incrementa se pone a la espera de que sea su turno
     */
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                secuenciador.siguiente();
                secuenciador.esperarPar();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Hilo interrumpido");
            }
            System.out.println("Contado es impar: " + secuenciador.getContador());
        }
    }
}
