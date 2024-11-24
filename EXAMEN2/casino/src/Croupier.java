public class Croupier extends Thread {
    private Banca banca;

    public Croupier(Banca banca) {
        this.banca = banca;
    }

    public void run() {
        while (!this.isInterrupted()) {
            try {
                Thread.sleep(3000);
                int numeroGanador = (int) (Math.random() * 10) + 1;
                System.out.println("------");
                System.out.println("El croupier ha girado la ruleta y ha salido el número " + numeroGanador);
                banca.indicarNumeroGanador(numeroGanador);

            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}