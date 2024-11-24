public class Jugador extends Thread {
    private Banca banca;
    private Croupier croupier;
    private int saldo;
    private int APUESTA = 10;
    private int APUESTA_GANADA = APUESTA * 5;
    private int numeroApostado;

    public Jugador(String name, Banca banca, Croupier croupier) {
        this.setName(name);
        this.banca = banca;
        this.croupier = croupier;
        this.saldo = 100;
    }

    public void apostar() {
        numeroApostado = (int) (Math.random() * 10) + 1;
        if (saldo >= APUESTA && saldo - APUESTA >= 0) {
            saldo -= APUESTA;
            System.out.println("El jugador " + this.getName() + " ha apostado " + APUESTA + "€ al número " + numeroApostado);

            synchronized (croupier) {
                try {
                    croupier.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (croupier.girarRuleta() == numeroApostado) {
                    saldo += APUESTA_GANADA;
                    banca.restarSaldo(APUESTA_GANADA);
                    System.out.println("El jugador " + this.getName() + " ha ganado " + APUESTA_GANADA + "€" + " [Saldo: " + saldo + "€]");
                    System.out.println("El saldo de la banca es de " + banca.getSaldo() + "€");
                } else {
                    banca.aumentarSaldo(APUESTA);
                    System.out.println("El jugador " + this.getName() + " ha perdido " + APUESTA + "€" + " [Saldo: " + saldo + "€]");
                    System.out.println("El saldo de la banca es de " + banca.getSaldo() + "€");
                }
            }
        }
    }

    public void run() {
        while (saldo > 0) {
            apostar();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}