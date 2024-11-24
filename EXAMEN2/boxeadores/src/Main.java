import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Ring ring = new Ring();

        Boxeador boxeador1 = new Boxeador("Boxeador 1",ring);
        Boxeador boxeador2 = new Boxeador("Boxeador 2",ring);
        Boxeador boxeador3 = new Boxeador("Boxeador 3",ring);
        Boxeador boxeador4 = new Boxeador("Boxeador 4",ring);

        List<Boxeador> boxeadores = List.of(boxeador1, boxeador2, boxeador3, boxeador4);

        boxeador1.setRival(boxeadores.get((int)(Math.random()*4)));
        boxeador2.setRival(boxeadores.get((int)(Math.random()*4)));
        boxeador3.setRival(boxeadores.get((int)(Math.random()*4)));
        boxeador4.setRival(boxeadores.get((int)(Math.random()*4)));

        boxeador1.start();
        boxeador2.start();
        boxeador3.start();
        boxeador4.start();

        boxeador1.join();
        boxeador2.join();
        boxeador3.join();
        boxeador4.join();

        System.out.println(boxeador1);
        System.out.println(boxeador2);
        System.out.println(boxeador3);
        System.out.println(boxeador4);


    }
}