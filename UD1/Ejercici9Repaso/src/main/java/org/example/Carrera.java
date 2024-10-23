package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Carrera {

    private Testigo testigo=new Testigo();

    public void iniciarCarrera(){
        for(int i=0;i<=4;i++){
            new Thread(new Atleta(i,testigo)).start();
        }
    }

    public static void main(String[] args) {
        System.out.println("La carrera está a punto de comenzar!");
        Carrera carrera = new Carrera();
        carrera.iniciarCarrera();
    }
}