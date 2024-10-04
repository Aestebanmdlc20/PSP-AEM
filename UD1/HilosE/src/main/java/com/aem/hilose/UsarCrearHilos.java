
public class UsarCrearHilos {
	public static void main(String[] args) throws Exception{
		Thread.currentThread().setName("Principal");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());
		
		for(int i=0; i<3; i++) {
			CrearHilos h =new CrearHilos(); //crear hilo
			h.setName("HILO"+i);  //damos nombre al hilo
			h.setPriority(i + 1); //damos prioridad
			h.start();  //iniciar hilo
			
			//System.out.println("Información del "+h.getName()+" : "+h.toString());
		}			
		
		System.out.println("3 HILOS CREADOS .... ");
		System.out.println("Hilos activos: "+ Thread.activeCount());
		
	}
}
