public class Ruleta {
    public static void main(String[] args) throws InterruptedException {
        Banca banca = new Banca();
        Croupier croupier = new Croupier("Croupier");
        Jugador jugador1 = new Jugador("Jugador 1", banca, croupier);
        Jugador jugador2 = new Jugador("Jugador 2", banca, croupier);
        Jugador jugador3 = new Jugador("Jugador 3", banca, croupier);
        Jugador jugador4 = new Jugador("Jugador 4", banca, croupier);

        croupier.start();
        jugador1.start();
        jugador2.start();
        jugador3.start();
        jugador4.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
        croupier.interrupt();
        jugador1.interrupt();
        jugador2.interrupt();
        jugador3.interrupt();
        jugador4.interrupt();
    }
}