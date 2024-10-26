package TP_EX3;

import java.util.concurrent.Semaphore;

public class Test {

    static Semaphore TP = new Semaphore(0);
    static Semaphore TA = new Semaphore(0);
    static Semaphore PA = new Semaphore(0);

    static Semaphore S = new Semaphore(1);

    public static void main(String[] args) {
        FumeurA A = new FumeurA();
        FumeurP P = new FumeurP();
        FumeurT T = new FumeurT();
        Agent agent = new Agent();

        agent.start();
        A.start();
        P.start();
        T.start();
    }
}
