package observer;

import java.util.GregorianCalendar;

/**
 *
 * @author link
 */
public class PatronObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto producto = new Producto();
		producto.setNombre("Patatas");
		producto.setDescripcion("Patatas fritas");
		producto.setPrecio(1.20f);
		producto.setStock(0);
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("CLI0001");
		cliente.setNombre("Un");
		cliente.setApellidos("tipo");
		cliente.setEmail("un@tipo.com");
		
		/*
		 * Se añaden observadores a la clase observable
		 */
		producto.addObserver(cliente);
		
		/*
		 * Un cambio en la clase observada hará "reaccionar" a la clase observadora
		 */
		producto.setStock(23);
		producto.setPrecio(1.50f);
		producto.setNombre("Prueba");
    }
    
}
