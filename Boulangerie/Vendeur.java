package Boulangerie;

public class Vendeur extends Thread {
	// constructor
	static int out = 0;
	int x;// nb de baguettes à prelever

	Vendeur(String nom, int x) {
		super(nom);
		this.x = x;
	}

	public void run() {
		// panier vide =>> obliger le vendeur à attendre

		try {
			Princiaple.Nbcaseplein.acquire(x);
			Princiaple.S.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//// section critique
		Baguette[] vendu = prelever();
		Princiaple.S.release();

		Princiaple.nbcaseVide.release(x);
	}

	Baguette[] prelever() {
		// creation du tableau retournée
		Baguette[] Sachet = new Baguette[x];
		// remplir sachet
		for (int i = 0; i < x; i++) {
			Sachet[i] = Princiaple.panier[(out + i) % Princiaple.taille];
		}
		System.out.println("le vendeur" + getName() +
				" preleve" + x + "baguettes");
		// avancer out
		out = (out + x) % Princiaple.taille;
		return Sachet;
	}

	// /*problemes à reosudre*////
	// 1. EX mutuelle entre boulanger et vendeur sur la panier
	// 2. panier plein=> obliger le boulanger à attendr
	// 3. panier vide =>> obliger le vendeur à attendre
}
