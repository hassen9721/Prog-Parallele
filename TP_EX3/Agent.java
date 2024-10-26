package TP_EX3;

public class Agent extends Thread {

    char[] ing = { 'T', 'P', 'A' };

    public void run() {
        while (true) {
            try {
                Test.S.acquire();
            } catch (Exception e) {
                // TODO: handle exception
            }

            // genertion de 2 ing
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            while (x == y) {
                y = (int) (Math.random() * 3);
            }
            char a = ing[x];
            char b = ing[y];
            if ((a == 'T' && b == 'P') || (a == 'P' && b == 'T')) {
                System.out.println("agent depose T et P");
                Test.TP.release();
            }
            if ((a == 'T' && b == 'A') || (a == 'A' && b == 'T')) {
                System.out.println("agent depose T et A");
                Test.TA.release();
            }
            if ((a == 'P' && b == 'A') || (a == 'A' && b == 'P')) {
                System.out.println("agent depose A et P");
                Test.PA.release();
            }
        }
    }
}
