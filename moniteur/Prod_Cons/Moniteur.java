package moniteur.Prod_Cons;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {

	private final ReentrantLock l = new ReentrantLock();
	// vp
	private int taille = 2;
	private int in, out = 0;
	private int[] tampon = new int[taille];
	private Condition C1 = l.newCondition();
	private Condition C2 = l.newCondition();
	private int nbcasevide = taille;

	// MEthodes
	void ajouter() {
		l.lock();
		try {
			// COND => ATTENTE
			while (nbcasevide == 0) {
				System.out.println("prod en attente");
				C1.await();
				System.out.println("prod quitte attente");
			}

			int x = (int) (Math.random() * 100);
			tampon[in] = x;
			System.out.println("prod depose" + x);
			in = (in + 1) % taille;
			nbcasevide = nbcasevide - 1;
			C2.signal();

		} catch (Exception e) {
		} finally {
			l.unlock();
		}
	}

	void prelever() {
		l.lock();
		try {
			while (nbcasevide == taille) {
				System.out.println("cons en attente");
				C2.await();
				System.out.println("cons quitte attente");
			}

			int y = tampon[out];
			out = (out + 1) % taille;
			System.out.println("cons preleve" + y);
			nbcasevide = nbcasevide + 1;
			C1.signal();
		} catch (Exception e) {
		} finally {
			l.unlock();
		}
	}

}
