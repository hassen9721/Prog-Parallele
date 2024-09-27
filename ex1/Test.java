package ex1;

import java.util.Scanner;

public class Test {
    static int taille = 10;
    int millieu = taille / 2;
    static int[] tab = new int[taille];

    void saisir() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tab.length; i++) {
            tab[i] = sc.nextInt();
        }
    }

    void affiche() {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    void fusion() {
        int i = 0;
        int j = millieu;
        int k = 0;
        int[] w = new int[taille];
        while ((i < millieu) && (j < taille)) {
            if (tab[i] < tab[j]) {
                w[k] = tab[i];
                i++;
                k++;
                if (i == millieu) {
                    for (int p = j; p < taille; p++) {
                        w[k] = tab[p];
                        p++;
                    }
                }
            } else {
                w[k] = tab[j];
                j++;
                k++;
                if (j == taille) {
                    for (int p = i; p < millieu; p++) {
                        w[k] = tab[p];
                        p++;
                    }
                }
            }
        }
        tab = w;
    }

    public static void main(String[] args) {

        Test t = new Test();
        t.saisir();

        ThreadTri tab1 = new ThreadTri(0, t.millieu);
        ThreadTri tab2 = new ThreadTri(t.millieu + 1, t.taille);

        tab1.start();
        tab2.start();
        try {
            tab1.join();
            tab2.join();
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
        t.fusion();
        t.affiche();
    }
}
