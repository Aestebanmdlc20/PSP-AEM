import java.util.LinkedList;

public class Cola {

    private int numElementosMaximos;
    LinkedList<Integer> cola;

    public Cola(int numElementosMaximos) {
        this.numElementosMaximos = numElementosMaximos;
        cola = new LinkedList<>();
    }

    public synchronized boolean estaLlena() {
        return cola.size() == numElementosMaximos;
    }

    public synchronized boolean encolar(int elemento) {
        boolean booEncolar = false;
        if (!estaLlena()) {
            cola.addLast(elemento);
            booEncolar = true;
        }
        return booEncolar;
    }

    public synchronized boolean desencolar(){
        boolean booDesencolado = false;
        if(!cola.isEmpty()){
            booDesencolado = true;
            int numDesencolado = cola.pop();
            System.out.println("Consumidor recuperó el número: " + numDesencolado);
        }
        return booDesencolado;
    }
}
