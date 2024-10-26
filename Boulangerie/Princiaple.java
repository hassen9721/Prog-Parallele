package Boulangerie;

import java.util.concurrent.Semaphore;

public class Princiaple {
	/// VP
	static int taille = 10;
	static Baguette[] panier = new Baguette[taille];
	static Semaphore S = new Semaphore(1, true);
	static Semaphore nbcaseVide = new Semaphore(taille);

	static Semaphore Nbcaseplein = new Semaphore(0);

	public static void main(String args[]) {
		// creation des instances de threads
		// lancement des threads paralleles
		Vendeur v1 = new Vendeur("A", 5);
		Vendeur v2 = new Vendeur("B", 6);
		Boulanger b1 = new Boulanger("boulanger1");
		v1.start();
		v2.start();
		b1.start();

	}

}
