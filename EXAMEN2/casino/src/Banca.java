public class Banca extends Thread{

    private int saldo;

    public Banca(){
        this.saldo = 1000;
    }

    public synchronized int getSaldo(){
        return saldo;
    }

    public synchronized void restarSaldo(int cantidadApostada){
        if(cantidadApostada < saldo){
            this.saldo -= cantidadApostada;
        }
    }


    public synchronized void aumentarSaldo(int cantidadApostada){
        this.saldo += cantidadApostada;
    }
}
