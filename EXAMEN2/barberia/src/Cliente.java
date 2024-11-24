public class Cliente extends Thread {
    private GestorSillas gestorSillas;

    public Cliente(GestorSillas gestorSillas, int numCliente) {
        this.gestorSillas = gestorSillas;
        this.setName("Cliente " + numCliente);
    }

    @Override
    public void run() {
        int posSilla = this.gestorSillas.ocupaSilla(this.getName());
        if (posSilla == -1) {
            System.out.println(this.getName() + " no había sillas libres, me marcho");
        } else {
            // Esperar a terminar
            while (gestorSillas.estaSillaOcupada(posSilla, this.getName())) {
                System.out.println(this.getName() + " estoy sentado en la silla: " + posSilla);
                try {
                    Thread.currentThread().sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getName() + " he sido atendido, me marcho");
        }
    }
}
