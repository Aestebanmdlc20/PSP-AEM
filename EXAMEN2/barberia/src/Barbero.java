public class Barbero extends Thread {
    GestorSillas gestorSillas;
    boolean barberiaAbierta;

    public Barbero(GestorSillas gestorSillas, int numBarbero) {
        this.gestorSillas = gestorSillas;
        this.barberiaAbierta = true;
        this.setName("Barbero " + numBarbero);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                this.gestorSillas.atenderCliente(this.getName());
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}
