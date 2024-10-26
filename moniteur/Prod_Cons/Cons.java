package moniteur.Prod_Cons;

public class Cons extends Thread {
	Moniteur M;

	Cons(Moniteur M) {
		this.M = M;
	}

	public void run() {
		M.prelever();
	}

}