package moniteur.Prod_Cons;

public class Test {

	public static void main(String args[]) {
		Moniteur M = new Moniteur();
		Prod p1 = new Prod(M);
		Prod p2 = new Prod(M);
		Prod p3 = new Prod(M);
		Cons C1 = new Cons(M);
		Cons C2 = new Cons(M);
		Cons C3 = new Cons(M);
		p1.start();
		p2.start();
		p3.start();
		C2.start();
		C1.start();
		C3.start();
	}
}
