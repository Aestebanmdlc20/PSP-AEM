package es.alejandro.dos;

public class Secuenciador {

    // Vamos a implementar el modelo Singleton para asegurarnos de que creamos una sola instancia

    private static Secuenciador instance; // Tenemos como propiedad privada instance para posteriormente instanciala
    private int contador;

    private Secuenciador(){ // Creamos el constructor privado para que no podamos crear el objeto mediante este
        this.contador=0;
    }

    /**
     * Metodo que se encarga de crear una instancia de la clase
     * Si instance es null crea una nueva instacia
     * Si no no hace nada
     */
    private synchronized static void createInstance(){
        if(instance == null){
            instance = new Secuenciador();
        }
    }

    /**
     * Metodo con el que obtenemos una instancia del objeto
     * Comprueba instance sea null, si es null llama al metodo createInstance();
     *
     * @return instance Instancia del objeto
     */

    public static Secuenciador getInstance(){
        if (instance == null){
            createInstance();
        }
        return instance;
    }

    /**
     * Metodo que incrementa el contador
     */
    public synchronized void siguiente(){
        this.contador++;
        notifyAll();
    }

    /**
     * Metodo que hace hace esperar al hilo por el que es invocado hasta que se le notifique
     * Se empleará para el hiloPar
     */
    public synchronized void esperarPar(){
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException("Hilo interrumpido");
        }
    }
    /**
     * Metodo que hace hace esperar al hilo por el que es invocado hasta que se le notifique
     * Se empleadrá para el hiloImpar
     */

    public synchronized void esperarImpar() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException("Hilo interrumpido");
        }
    }

    /**
     * Devuelve el contador
     * @return contador Entero con el valor del contador
     */
    public int getContador(){
        return this.contador;
    }

}
