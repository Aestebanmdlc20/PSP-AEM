public class Boxeador extends Thread{

    private Ring ring;
    private boolean booNoqueado;
    private int golpesDados;
    private int golpesRecibidos;
    private int golpesNoqueo;
    private Boxeador rival;

    public Boxeador(String nombre,Ring ring) {
        this.setName(nombre);
        this.ring = ring;
        this.booNoqueado=false;
        this.golpesDados=0;
        this.golpesRecibidos=0;
        this.golpesNoqueo=0;
    }

    public void setRival(Boxeador rival) {
        this.rival = rival;
        System.out.println("El boxeador "+this.getName()+" tiene como rival al boxeador "+rival.getName());
    }

    public int getGolpesDados() {
        return golpesDados;
    }

    public void pegar(){
        golpesDados++;
    }

    public void recibir(){
        golpesRecibidos++;
        if(golpesNoqueo==3){
            booNoqueado=true;
            this.golpesNoqueo=0;
        } else{
            golpesNoqueo++;
        }
    }

    @Override
    public void run() {
        while(ring.getNumCombates() < 100){
            if(booNoqueado){
                System.out.println("El boxeador "+this.getName()+" ha sido noqueado");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                booNoqueado=false;
            } else{
                ring.competir(this,this.rival);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public String toString(){
        return "El boxeador "+this.getName()+" ha dado "+this.golpesDados+" golpes y ha recibido "+this.golpesRecibidos+" golpes";
    }

}
