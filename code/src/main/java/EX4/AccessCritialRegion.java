package EX4;
/*
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX3
 *
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class AccessCritialRegion implements Runnable {

    private Semaphore semaphore;
    private CriticalRegion criticalRegion;

    AccessCritialRegion(Semaphore semaphore, CriticalRegion criticalRegion) {
        this.semaphore = semaphore;
        this.criticalRegion = criticalRegion;
    }

    private void increment(){
        try {
            semaphore.acquire();
            criticalRegion.getCriticalRegion();
            Random r = new Random();
            // Gera um número aleatório entre 5000 e 10000
            int sleepTime = r.nextInt((10000 - 5000) + 1) + 5000;
            Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos
            System.out.println("[ "+ Thread.currentThread().getName() +" ] Liberando região crítica e.e");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void run() {
        increment();
    }
}
