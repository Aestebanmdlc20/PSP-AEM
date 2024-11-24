public class Filosofo extends Thread {

    GestorCubiertos gestorCubiertos;
    int posCubiertoIzq;
    int posCubiertoDer;

    public Filosofo(String nombre, GestorCubiertos gestorCubiertos, int posCubiertoIzq, int posCubiertoDer){
        this.setName(nombre);
        this.gestorCubiertos = gestorCubiertos;
        this.posCubiertoIzq = posCubiertoIzq;
        this.posCubiertoDer = posCubiertoDer;
    }

    public void run(){

        while(true) {
            boolean cogerCubiertos = gestorCubiertos.cogerCubiertos(posCubiertoIzq, posCubiertoDer);
            if (cogerCubiertos) {
                comer();
                gestorCubiertos.liberarCubiertos(posCubiertoIzq, posCubiertoDer);
                try {
                    pensar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void comer(){
        System.out.println("--- Filosofo " + Thread.currentThread().getName() + " comiendo con los cubiertos " + posCubiertoIzq + " y " + posCubiertoDer);
    }

    private void pensar() throws InterruptedException {
        System.out.println("--- Filosofo " + Thread.currentThread().getName() + " pensando");
        Thread.sleep(5000);
    }

}
