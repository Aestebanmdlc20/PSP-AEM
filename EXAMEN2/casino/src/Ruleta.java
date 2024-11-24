public class Ruleta {
    public static void main(String[] args) throws InterruptedException {
        Banca banca = new Banca();


        Jugador [] jugadores = new Jugador[4];
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador("Jugador " + (i+1), banca);
        }

        for (Jugador jugador : jugadores) {
            jugador.start();
        }

        Croupier croupier = new Croupier(banca);
        croupier.start();
        for (Jugador jugador : jugadores) {
            jugador.join();
        }
        croupier.interrupt();

    }
}