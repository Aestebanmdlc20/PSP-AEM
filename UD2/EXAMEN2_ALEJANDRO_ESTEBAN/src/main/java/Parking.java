public class Parking {
    private boolean coches[];
    private String cocheNombres[];
    private String PLAZA_LIBRE = "LIBRE";
    private int numPlazas;

    public Parking (int numPlazas){
        this.numPlazas = numPlazas;
        coches = new boolean[numPlazas];
        cocheNombres = new String[numPlazas];
        for (int i=0; i<numPlazas;i++){
            coches[i] = true;
            cocheNombres[i] = PLAZA_LIBRE;
        }
    }

    private synchronized int getPlazaLibre(){
        boolean booContinuar = true;
        int pos = -1;
        for(int i = 0; i < numPlazas && booContinuar;i++){
            if(coches[i] == true){
                pos = i;
                booContinuar = false;
            }
        }
        return pos;
    }

    private synchronized int getPlazaOcupada(Coche coche){
        int plazaOcupada=-1;
        for(int i = 0; i<numPlazas;i++){
            if(cocheNombres[i].equals(coche.getName())){
                plazaOcupada = i;
            }
        }
        return plazaOcupada;
    }

    public synchronized boolean cocheDentro(Coche coche){
        boolean estaDentro=false;
        for(int i = 0; i < numPlazas; i++){
            if(cocheNombres[i].equals(coche.getName())){
                estaDentro = true;
            }
        }
        return estaDentro;
    }

    public synchronized boolean entrar(Coche coche) throws InterruptedException{
        boolean entra = false;
        int plazaLibre = getPlazaLibre();
        if (plazaLibre != -1){
            coches[plazaLibre]=false; // False = ocupada |=========| True = libre
            cocheNombres[plazaLibre] = coche.getName();
            entra = true;
            System.out.println("El coche " + coche.getName() + " ha entrado al parking a la plaza numero " + plazaLibre);
            consultarEstadoParking();
        }
        return entra;
    }

    public synchronized void salir(Coche coche) throws InterruptedException{
        boolean cocheDentro = cocheDentro(coche);
        int plazaOcupa = getPlazaOcupada(coche);
        if(plazaOcupa != -1 && cocheDentro == true){
            coches[plazaOcupa] = true; // Plaza libre
            cocheNombres[plazaOcupa] = PLAZA_LIBRE;
            System.out.println("El coche " + coche.getName() + " ha salido del parking de la plaza número: " + plazaOcupa);
            consultarEstadoParking();
        }
    }

    private synchronized void consultarEstadoParking(){
        int plazasLibres=0;
        for(int i = 0; i < numPlazas; i++){
            if(cocheNombres[i].equals(PLAZA_LIBRE) ){
                plazasLibres++;
            }
        }

        System.out.println("Plazas libre: " + plazasLibres);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < numPlazas; i++){
            sb.append(coches[i] + " ");
        }
        System.out.println("Parking " + "[" + sb.toString() +"]");

    }
}
