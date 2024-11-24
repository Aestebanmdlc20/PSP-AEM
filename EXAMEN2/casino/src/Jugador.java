public class Jugador extends Thread {
    private Banca banca;
    private int saldo;
    private final static int SALDO_INICIAL = 100;
    public static final int APUESTA = 10;
    public static final int APUESTA_GANADA = APUESTA * 5;
    private int numeroApostado;

    public Jugador(String name, Banca banca) {
        this.setName(name);
        this.banca = banca;
        this.saldo = SALDO_INICIAL;
    }

    public void run(){

        boolean booTieneSaldo = (saldo >0) ? true : false;
        while (booTieneSaldo){

            if(saldo - APUESTA >= 0){
                numeroApostado = (int) (Math.random() * 10) + 1;
                System.out.println("El jugador " + this.getName() + " ha apostado " + APUESTA + "€ al número " + numeroApostado);
                saldo = saldo - APUESTA;
                banca.recibirApuesta(APUESTA);

                try {
                    banca.comprobarResultado(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.interrupt();
                }

            } else{
                System.out.println("El jugador " + this.getName() + " no tiene saldo suficiente para apostar");
                booTieneSaldo = false;
            }
        }

    }
    public int getNumeroApostado() {
        return numeroApostado;
    }

    public void incrementarSaldo(int cantidad){
        saldo += cantidad;
    }

    public int getSaldo(){
        return saldo;
    }

}