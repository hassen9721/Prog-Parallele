package EX2;

import java.util.concurrent.Semaphore;

public class Test {

    static int taille = 10;
    public static int[] tompon = new int[taille];
    static Semaphore S = new Semaphore(1, true); // imposer la file FIFO
    static Semaphore nbplacevide = new Semaphore(taille);
    static Semaphore nbplacePlein = new Semaphore(0);

    public static void main(String[] args) {

        Producteur p1 = new Producteur();
        Producteur p2 = new Producteur();
        Producteur p3 = new Producteur();
        Producteur p4 = new Producteur();
        Producteur p5 = new Producteur();
        Producteur p6 = new Producteur();

        Consommateur c1 = new Consommateur();
        Consommateur c2 = new Consommateur();
        Consommateur c3 = new Consommateur();
        Consommateur c4 = new Consommateur();
        Consommateur c5 = new Consommateur();
        Consommateur c6 = new Consommateur();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
    }
}
