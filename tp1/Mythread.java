public class Mythread extends Thread {
    Mythread() {
    }

    Mythread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i + " " + getName());
        }
    }
}
