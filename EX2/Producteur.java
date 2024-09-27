package EX2;

public class Producteur extends Thread {

    static int i = 0;

    public void run() {
        try {
            // if tampon plein => attendre
            // else
            Test.nbplacevide.acquire();
            Test.S.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // appel de la methode produire
        produire();

        Test.S.release();
        Test.nbplacePlein.release();
    }

    public void produire() {
        int x = (int) (Math.random() * 100);
        Test.tompon[i] = x;
        i = (i + 1) % 10;
    }

}
