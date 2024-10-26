package EX1_madame;

import java.util.Scanner;

public class TestTri {
	static int[] Tab; // tableau � trier
	int n;

	public TestTri() {
		Tab = new int[100];
	}

	void affiche() {
		for (int p = 0; p < n; p++)
			System.out.println("T[" + p + "]" + Tab[p] + "\n");
	}

	void fusion() {
		int W[] = new int[100];
		int deb = 0;
		int fin = n;
		int milieu = deb + (fin - deb) / 2;
		int i = deb;
		int j = milieu;
		int k = 0;
		while ((i < milieu) && (j < fin)) {
			if (Tab[i] < Tab[j]) {
				W[k] = Tab[i];
				k++;
				i++;
				if (i >= milieu) {
					for (int p = j; p < fin; p++) {
						W[k] = Tab[p];
						k++;
					}
				}
			} else {
				W[k] = Tab[j];
				k++;
				j++;
				if (j >= fin) {
					for (int p = i; p < milieu; p++) {
						W[k] = Tab[p];
						k++;
					}
				}
			}
		}
		for (int p = deb; p < fin; p++)
			Tab[p] = W[p];
	}

	void saisie() {

		Scanner Sc = new Scanner(System.in);
		System.out.println("donne une entier inf a 100");
		n = Sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("T[" + i + "]= ");
			Tab[i] = Sc.nextInt();
		}
	}

	public static void main(String[] args) {

		TestTri test = new TestTri();
		test.saisie();
		int deb = 0;
		int fin = test.n;
		int milieu = deb + (fin - deb) / 2;

		Trieur tri1 = new Trieur(deb, milieu);
		tri1.start();
		Trieur tri2 = new Trieur(milieu, fin);
		tri2.start();
		try {
			tri1.join();
			tri2.join();
		} catch (InterruptedException e) {
		}
		test.fusion();
		test.affiche();
	}
}
