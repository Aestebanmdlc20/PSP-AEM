public class GestorSillas {

    private String[] sillas;
    private int numSillas;


    public GestorSillas(int numSillas){
        this.numSillas = numSillas;
        sillas = new String[numSillas];

        for (int i = 0; i < sillas.length; i++) {
            sillas[i] = null;
        }

    }

    private synchronized int getSillaLibre(){
        int pos = -1;
        boolean booContinuar=false;
        for(int i = 0; i < sillas.length && !booContinuar; i++){
            if(sillas[i] == null){
                pos = i;
                booContinuar=true;
            }
        }
        return pos;
    }

    public synchronized int ocupaSilla(String nombre){

        int sillaLibre = getSillaLibre();
        if(sillaLibre != -1){
            System.out.println("El cliente " + nombre + " se ha sentado en la silla " + sillaLibre);
            sillas[sillaLibre] = nombre;
        }
        return sillaLibre;
    }

    private synchronized int getSillaOcupada(){
        int pos = -1;
        boolean booContinuar=false;
        for(int i = 0; i < sillas.length && !booContinuar; i++){
            if(sillas[i] != null){
                pos = i;
                booContinuar=true;
            }
        }
        return pos;
    }

    public synchronized void atenderCliente (String nombreBarbero){

        int sillaOcupada = getSillaOcupada();
        if (sillaOcupada != -1){
            System.out.println("El barbero " + nombreBarbero + " esta atendiendo al cliente " + sillas[sillaOcupada] + " en la silla " + sillaOcupada);
            sillas[sillaOcupada] = null;
            System.out.println("Silla " + sillaOcupada + " liberada");
        }
    }

    public synchronized boolean estaSillaOcupada(int pos, String nombreCliente){
        return nombreCliente.equals(sillas[pos]);
    }


}
