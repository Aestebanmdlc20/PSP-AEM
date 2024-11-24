public class Ring {

    private int numCombates;

    private static Object object = new Object();

    public int getNumCombates() {
        synchronized (object) {
            return numCombates;
        }
    }

    public void competir(Boxeador boxeador1, Boxeador boxeador2) {

        boxeador1.pegar();
        boxeador2.recibir();

        synchronized (object) {
            numCombates++;
        }
        System.out.println("El boxeador " + boxeador1.getName() + " ha pegado al boxeador " + boxeador2.getName());
    }

}
