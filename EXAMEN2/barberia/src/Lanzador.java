//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lanzador {

    public final static int NUMERO_CLIENTES = 50;
    public final static int NUMERO_SILLAS = 10;
    public final static int NUMERO_BARBEROS = 5;

    public static void main(String[] args) throws InterruptedException {

        GestorSillas gestorSillas = new GestorSillas(NUMERO_SILLAS);

        // Barberos
        Barbero[] barbero = new Barbero[NUMERO_BARBEROS];
        for (int i = 0; i < NUMERO_BARBEROS; i++) {
            barbero[i] = new Barbero(gestorSillas,i+1);
            barbero[i].start();
        }

        // Clientes
        Cliente[] clientes = new Cliente[NUMERO_CLIENTES];
        for(int i = 0; i < NUMERO_CLIENTES; i++){
            clientes[i] = new Cliente(gestorSillas, "Cliente " + i);
            clientes[i].start();
            Thread.sleep(10);
        }
        // Esperamos a que terminen todos los clientes
        for (int i = 0; i < NUMERO_CLIENTES; i++) {
            clientes[i].join();
        }
        System.out.println("Todos los clientes han sido atendidos");

        // Interrumpimos a los barberos
        for (int i = 0; i < NUMERO_BARBEROS; i++) {
            barbero[i].interrupt();
        }

        System.out.println("Todos los barberos han terminado su jornada laboral");
        Thread.sleep(10000);
        System.out.println("Barberia cerrada");

    }
}