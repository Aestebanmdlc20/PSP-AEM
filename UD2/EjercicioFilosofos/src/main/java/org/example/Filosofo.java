package org.example;

class Filosofo implements Runnable {

    private String idFilosofo;
    private int tenedorInstruccion;
    Object tenedorDerecho;
    Object tenedorIzquierdo;

    public Filosofo(String idFilosofo, Object tenedorDerecho, Object tenedorIzquierdo, int tenedorInstruccion) {
        this.idFilosofo = idFilosofo;
        this.tenedorDerecho = tenedorDerecho;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorInstruccion = tenedorInstruccion;
    }

    public void run() {
        while (true) {
            System.out.println(idFilosofo + " Tiene ganas de comer");
            if (this.tenedorInstruccion == 1) {
                synchronized (tenedorDerecho) {
                    tomarTenedor("derecho");
                    synchronized (tenedorIzquierdo) {
                        tomarTenedor("izquierdo");
                        comer();
                        this.tenedorInstruccion = 0;
                    }
                }
                pensar();
            } else if (this.tenedorInstruccion == 2) {
                synchronized (tenedorIzquierdo) {
                    tomarTenedor("izquierdo");
                    synchronized (tenedorDerecho) {
                        tomarTenedor("derecho");
                        comer();
                        this.tenedorInstruccion = 0;
                    }
                }
                pensar();
            }
        }
    }

    public void pensar() {
        try {
            System.out.println(idFilosofo + " está pensando");
            int pausa = (int) (Math.random() * 3000);
            Thread.sleep(pausa);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    public void tomarTenedor(String tenedor) {
        try {
            System.out.println(idFilosofo + " coge su tenedor " + tenedor);
            int pausa = (int) (Math.random() * 3000);
            Thread.sleep(pausa);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    public void comer() {
        try{
            System.out.println(idFilosofo + " está comiendo");
            int pausa = (int) (Math.random() * 3000);
            Thread.sleep(pausa);
            System.out.println(idFilosofo + " deja de comer");
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }
}
