public class Lanzador {
    private final static int NUM_PLAZAS = 5;
    private final static int NUM_COCHES = 10;
    public static void main(String[] args) throws InterruptedException {
        // Creamos el parking
        Parking parking = new Parking(NUM_PLAZAS);

        // Creamos los coches y los inciamos
        Coche[] coches = new Coche[10];

        for(int i = 0; i < NUM_COCHES; i++){
            Coche coche = new Coche("Coche"+i, parking);
            coches[i] = coche;
            coche.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw e;
        }

        for(int i = 0; i < NUM_COCHES; i++){
            coches[i].interrupt();
        }

        System.out.println("El parking ha cerrado");

    }
}
