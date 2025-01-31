import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Libreria {

    private Map<String,Integer> libreria = new HashMap<>();

    public Libreria() {
        libreria.put("El principito", 5);
        libreria.put("El señor de los anillos", 3);
        libreria.put("Harry Potter", 7);
        libreria.put("Cien años de soledad", 2);
        libreria.put("Don Quijote de la Mancha", 1);
        libreria.put("El alquimista", 4);

        System.out.println("Libreria inicializada");
        System.out.println(this);
    }

    public synchronized Libro atenderPedidos(Libro libroSolicitado){
        Libro libroEnviado = new Libro(libroSolicitado.getNombre());
        int numLibrosDevueltos = 0;

        if(libreria.containsKey(libroSolicitado.getNombre())){

            Integer numLibrosDisponibles = libreria.get(libroSolicitado.getNombre());
            if(numLibrosDisponibles>=libroSolicitado.getNumLibros()) {
                numLibrosDevueltos = libroSolicitado.getNumLibros();
            } else {
                numLibrosDevueltos = numLibrosDisponibles;
            }

            // Actualizar inventario

            libreria.put(libroSolicitado.getNombre(), numLibrosDisponibles - numLibrosDevueltos);
            System.out.println(this);
        }

        // Actualizar numero de libros enviados

        libroEnviado.setNumLibros(numLibrosDevueltos);
        return libroEnviado;

    }

    @Override
    public String toString() {
        return "Libreria{" +
                "libreria=" + libreria +
                '}';
    }

}
