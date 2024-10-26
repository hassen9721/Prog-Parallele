package TP_EX3;

public class FumeurP extends Thread {
    public void run() {
        while (true) {
            try {
                Test.TA.acquire(); // attendre sur TP
                System.out.println("Fumeur P fume");
                Thread.sleep(1000);

                Test.S.release();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}