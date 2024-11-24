public class GestorCubiertos {

    boolean cubiertoLibre[];

    public GestorCubiertos(int numCubierto){
        cubiertoLibre = new boolean[numCubierto];
        for(int i = 0; i < numCubierto; i++){
            cubiertoLibre[i] = true;
        }
    }

    public synchronized boolean cogerCubiertos(int pos1, int pos2){

        boolean seConsigue = false;
        if(cubiertoLibre[pos1] && cubiertoLibre[pos2]){
            cubiertoLibre[pos1] = false;
            cubiertoLibre[pos2] = false;
            seConsigue = true;
            System.out.println("Cubiertos bloqueados: " + pos1 + " y " + pos2);
        }
        return seConsigue;
    }

    public synchronized void liberarCubiertos(int pos1, int pos2){
        cubiertoLibre[pos1] = true;
        cubiertoLibre[pos2] = true;
        System.out.println("Cubiertos liberados: " + pos1 + " y " + pos2);
    }

}
