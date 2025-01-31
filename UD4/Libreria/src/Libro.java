import java.io.Serializable;

public class Libro implements Serializable {
    private String nombre;
    private int numLibros;

    public Libro(String nombre, int numLibros) {
        this.nombre = nombre;
        this.numLibros = numLibros;
    }

    public Libro (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

}
