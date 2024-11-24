public class Cliente extends Thread{

    private GestorSillas gestorSillas;

    public Cliente(GestorSillas gestorSillas, String nombre){
        this.setName(nombre);
        this.gestorSillas = gestorSillas;
    }

    public void run(){
        int posSilla = this.gestorSillas.ocupaSilla(this.getName());
        if(posSilla == -1){
            System.out.println("El cliente " + this.getName() + " no ha encontrado silla libre");
        } else{
            while(gestorSillas.estaSillaOcupada(posSilla, this.getName())){
                System.out.println("El cliente " + this.getName() + " se ha sentado en la silla " + posSilla);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("El cliente " + this.getName() + " ha sido atendido y se marcha");
        }
    }

}
