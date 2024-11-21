package org.example;

class Filosofo implements Runnable {

    private String idFilosofo;
    Object tenedorDerecho;
    Object tenedorIzquierdo;

    public Filosofo(String idFilosofo, Object tenedorDerecho, Object tenedorIzquierdo) {
        this.idFilosofo = idFilosofo;
        this.tenedorDerecho = tenedorDerecho;
        this.tenedorIzquierdo = tenedorIzquierdo;
    }

    public void run() {
        while (true) {
            System.out.println(idFilosofo + " Tiene ganas de comer");
            synchronized (tenedorDerecho) {
                synchronized (tenedorIzquierdo) {
                    cogerTenedor("derecho e izquierdo");
                    comer();
                }
            }
            pensar();
        }
    }

    public void pensar() {
        try {
            System.out.println(idFilosofo + " esta pensando");
            int pausa = (int) (Math.random() * 3000);
            Thread.sleep(pausa);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    public void cogerTenedor(String tenedor) {
        try {
            System.out.println(idFilosofo + " coge su tenedor " + tenedor);
            int pausa = (int) (Math.random() * 3000);
            Thread.sleep(pausa);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    public void comer() {
        try {
            System.out.println(idFilosofo + " esta comiendo");
            int pausa = (int) (Math.random() * 3000);
            Thread.sleep(pausa);
            System.out.println(idFilosofo + " deja de comer");
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }
}