package es.alejandro.dos;

public class HiloImpar implements Runnable{

    /**
     * Metodo run que se encarga de cambiar el estado del hilo
     * Espera a ser notificado para incrementar el contador
     * Una vez los incrementa se pone a la espera de que sea su turno
     */
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Secuenciador.getInstance().esperarImpar();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
