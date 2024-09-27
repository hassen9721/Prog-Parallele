public class Test {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        Mythread t2 = new Mythread();

        Mythread t3 = new Mythread("test 3");
        Mythread t4 = new Mythread("test 4");

        System.out.println("Debut");
        // t1.start();
        // t2.start();
        t3.start();
        t4.start();
        try {
            // t1.join();
            // t2.join();
            t3.join();
            t4.join();
            System.out.println("je suis à la fin de main");
        } catch (InterruptedException e) {
            // TODO: handle exception
        }

    }
}
