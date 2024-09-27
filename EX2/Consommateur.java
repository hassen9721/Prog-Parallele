package EX2;

public class Consommateur extends Thread {
    static int out = 0;

    public void run() {
        try {
            Test.nbplacePlein.acquire();
            Test.S.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }

        prelever();
        Test.S.release();
        Test.nbplacevide.release();
    }

    void prelever() {
        int y = Test.tompon[out];
        System.out.println("le consommateur preleve" + y);
        out = (out + 1) % Test.taille;

    }

    /* Probleme à résoudre */
    // 1.prob d'ex mutuelle entre prod et con sur le tompon
    // 2.tompon plein => obliger prod a attendre
    // 3.tompon vide => obliger cons a attendre

}
