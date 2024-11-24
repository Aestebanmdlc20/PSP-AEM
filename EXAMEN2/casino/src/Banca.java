public class Banca extends Thread{

    private static final int SALDO_INICIAL = 1000;

    private int saldo;

    private int numeroGanador;

    public Banca(){
        this.saldo = SALDO_INICIAL;
    }

    public synchronized void indicarNumeroGanador(int numeroGanador){
        this.numeroGanador = numeroGanador;
        notifyAll();
    }

    public synchronized void recibirApuesta(int cantidadApostada){
        this.saldo += cantidadApostada;
    }

    public synchronized int getSaldo(){
        return saldo;
    }

    public synchronized boolean pagar(int cantidad){
        boolean booPagar = false;
        if ((saldo - cantidad) >= 0){
            saldo = saldo - cantidad;
            booPagar = true;
        }
        return booPagar;
    }

    public synchronized void comprobarResultado(Jugador jugador) throws InterruptedException {
        this.wait();

        if(jugador.getNumeroApostado() == numeroGanador){
            int ganancia = Jugador.APUESTA_GANADA;

            if(pagar(ganancia)){
                jugador.incrementarSaldo(ganancia);
                System.out.println("El jugador " + jugador.getName() + " ha ganado " + ganancia + "€" + " [Saldo: " + jugador.getSaldo() + "€]");
            }
            else{
                System.out.println("La banca no tiene suficiente saldo para pagar al jugador " + jugador.getName());
            }

        } else {
            System.out.println("El jugador " + jugador.getName() + " ha perdido " + Jugador.APUESTA + "€" + " [Saldo: " + jugador.getSaldo() + "€]");
        }

    }
}
