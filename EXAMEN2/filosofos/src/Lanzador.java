
public class Lanzador {
    public static void main(String[] args) {

        int NUM_PROCESOS = 5;

        GestorCubiertos gestorCubiertos = new GestorCubiertos(NUM_PROCESOS);

        Filosofo[] mesa  = new Filosofo[NUM_PROCESOS];
        Filosofo filosofo;

        int posCubiertoIzq, posCubiertoDer;

        for (int i=0 ; i<NUM_PROCESOS ; i++){
            if(i==0){
                posCubiertoIzq = NUM_PROCESOS-1; // 4
                posCubiertoDer = i; // 0
            } else {
                posCubiertoIzq = i-1; // 0, 1, 2, 3
                posCubiertoDer = i; // 1, 2, 3, 4
            }
            filosofo = new Filosofo("Filosofo " + i, gestorCubiertos, posCubiertoIzq, posCubiertoDer);
            mesa[i] = filosofo;
        }

        for (int i=0 ; i<NUM_PROCESOS ; i++){
            mesa[i].start();
        }

    }
}