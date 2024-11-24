public class Croupier extends Thread {
    private int numeroGanador;

    public Croupier(String name) {
        this.setName(name);
        this.numeroGanador = 0;
    }

    public synchronized int girarRuleta() {
        return numeroGanador = (int) (Math.random() * 10) + 1;
    }

    public void run() {
        while (!this.isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {
                int num = girarRuleta();
                System.out.println("El croupier ha girado la ruleta y ha salido el número " + num);
                notifyAll();
            }
        }
    }
}