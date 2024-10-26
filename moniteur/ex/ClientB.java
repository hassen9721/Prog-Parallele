package moniteur.ex;

public class ClientB extends Thread {
    Moniteur M;

    ClientB(Moniteur M) {
        this.M = M;
    }

    public void run() {
        M.annuler();
    }
}
