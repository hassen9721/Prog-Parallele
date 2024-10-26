package moniteur.Prod_Cons;

public class Prod extends Thread {
	Moniteur M;

	Prod(Moniteur M) {
		this.M = M;
	}

	public void run() {
		M.ajouter();
	}

}
