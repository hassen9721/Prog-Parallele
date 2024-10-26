package moniteur.ex;

public class ClientA extends Thread {
    Moniteur M;

    ClientA(Moniteur M) {
        this.M = M;
    }

    public void run() {
        M.reserver();
    }
}
