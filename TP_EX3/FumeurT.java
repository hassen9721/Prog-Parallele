package TP_EX3;

public class FumeurT extends Thread {
    public void run() {
        while (true) {
            try {
                Test.PA.acquire(); // attendre sur TP
                System.out.println("Fumeur T fume");
                Thread.sleep(1000);

                Test.S.release(); // pour declancher l'agent
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
