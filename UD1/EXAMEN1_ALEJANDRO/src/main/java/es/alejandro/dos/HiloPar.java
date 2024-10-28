package es.alejandro.dos;

public class HiloPar implements Runnable{
    Secuenciador secuenciador;

    public HiloPar(Secuenciador secuenciador) {
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
                secuenciador.esperarImpar();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Hilo interrumpido!");
            }
            System.out.println("Contador es par: " + secuenciador.getContador());
        }
    }
}
