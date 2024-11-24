
public class Lanzador {

    private final static int MAX_PRODUCTORES = 5;
    private final static int MAX_CONSUMIDORES = 7;
    private final static int MAX_ELEMENTOS = 10;

    public static void main(String[] args) {
        Cola colaCompartida = new Cola(MAX_ELEMENTOS);

        for (int i = 0; i < MAX_PRODUCTORES; i++) {
            Productor productor = new Productor(colaCompartida);
            productor.start();
        }

        for (int i = 0; i < MAX_CONSUMIDORES; i++) {
            Conusmidor consumidor = new Conusmidor(colaCompartida);
            consumidor.start();
        }
        
    }
}