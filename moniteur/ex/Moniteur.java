package moniteur.ex;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {
  // VP
  private int nb_place = 0;

  private final ReentrantLock l = new ReentrantLock();
  private final Condition C1 = l.newCondition();

  void reserver() {
    l.lock();
    try {

      // Faux
      // if (nb_place>0) {
      // nb_place=nb_place-1;
      // } else C1.await();

      while (nb_place == 0) {
        System.out.println("process en attente");
        C1.await();
        System.out.println("process quitte attente");
      }
      nb_place = nb_place - 1;
      System.out.println("process reserve");

    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      l.unlock();
    }
  }

  void annuler() {
    l.lock();
    try {
      nb_place = nb_place + 1;
      System.out.println("process libere");
      C1.signal();

    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      l.unlock();
    }
  }
}
