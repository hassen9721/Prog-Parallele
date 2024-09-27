package EX1_P15_CH2;

import java.util.concurrent.Semaphore;

public class Client extends Thread {
    // variable partagée
    public static int nb_place = 1;
    static Semaphore s = new Semaphore(1);

    Client(String name) {
        super(name);
    }

    public void run() {
        /*********************** PROTOCOLE D'ENTRE *********************/
        try {
            s.acquire(); // par obligation elle leve une exeption car elle est atomique : wait();
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        reserver();
        s.release(); // signal();
    }

    void reserver() {
        if (nb_place > 0) {
            System.out.println("Thread " + getName());
            nb_place--;
        }
    }
}
