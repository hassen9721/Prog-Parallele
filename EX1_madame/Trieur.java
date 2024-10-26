package EX1_madame;

public class Trieur extends Thread {
	public int debut, fin;

	public Trieur(int debut, int fin) {
		this.debut = debut;
		this.fin = fin;
	}

	public void run() {
		int x;
		for (int i = debut; i < fin - 1; i++) {
			for (int j = i + 1; j < fin; j++) {
				if (TestTri.Tab[i] > TestTri.Tab[j]) {
					x = TestTri.Tab[j];
					TestTri.Tab[j] = TestTri.Tab[i];
					TestTri.Tab[i] = x;
				}
			}
		}
	}
}
