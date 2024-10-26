package TP_EX3;

public class FumeurA extends Thread {
    public void run() {
        while (true) {
            try {
                Test.TP.acquire(); // attendre sur TP
                System.out.println("Fumeur A fume");
                Thread.sleep(1000);

                Test.S.release();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
