package Boulangerie;

public class Boulanger extends Thread {
	static int in = 0;// partagé entre les boulangers

	Boulanger(String nom) {
		super(nom);
	}

	public void run() {
		///// if panier plein=> attendre
		try {
			Princiaple.nbcaseVide.acquire();
			Princiaple.S.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//// section critique
		ajouter();
		Princiaple.S.release();
		Princiaple.Nbcaseplein.release();
	}

	void ajouter() {
		// creation de l'instance de baguette
		Baguette B = new Baguette();
		// placement de la baguette dans le panier
		Princiaple.panier[in] = B;
		System.out.println("le boulanger" + getName() +
				" preleve" + 1 + "baguettes");
		// incremetation de in
		in = (in + 1) % Princiaple.taille;
	}

}
