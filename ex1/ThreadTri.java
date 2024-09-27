package ex1;

public class ThreadTri extends Thread {

    int debut;
    int fin;

    ThreadTri(int debut, int fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public void run() {
        int aux = 0;
        for (int i = debut; i < fin - 1; i++) {
            for (int j = i + 1; j < fin; j++) {
                if (Test.tab[i] > Test.tab[j]) {
                    aux = Test.tab[j];
                    Test.tab[j] = Test.tab[i];
                    Test.tab[i] = aux;
                }
            }
        }
    }
}
