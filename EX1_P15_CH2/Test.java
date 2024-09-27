package EX1_P15_CH2;

public class Test {
    public static void main(String[] args) {
        Client c1 = new Client("c1");
        Client c2 = new Client("c2");
        // Semaphore S = new Semaphore(1,true); //imposer la file FIFO
        c1.start();
        c2.start();
        try {
            c1.join();
            c2.join();
            System.out.println("nombre de place :" + Client.nb_place);
        } catch (InterruptedException e) {
            // TODO: handle exception
        }

    }
}
