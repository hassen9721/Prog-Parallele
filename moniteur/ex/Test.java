package moniteur.ex;

public class Test {
    public static void main(String[] args) {
        Moniteur M = new Moniteur();
        ClientA A = new ClientA(M);
        ClientA C = new ClientA(M);
        ClientB B = new ClientB(M);

        A.start();
        C.start();
        B.start();
    }
}
