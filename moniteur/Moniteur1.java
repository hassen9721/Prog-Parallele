package moniteur;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur1 {

    // VP
    private int x = 0;

    private final ReentrantLock l = new ReentrantLock(); // neceesaire pour le regle 1 & 2
    private final Condition C1 = l.newCondition();
    // methodes

    void m1() {
        l.lock(); // fermer le verrou
        try {
            while (x < 0) {
                C1.await();
            }
            x = x + 1;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            l.unlock(); // ouvrir le verrou
        }
    }

    void m2() {
        l.lock();
        try {
            x = x + 10;
            C1.signal();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            l.unlock();
        }
    }

}
