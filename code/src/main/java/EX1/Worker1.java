package EX1;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX1
 *
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Worker1 implements Runnable {

    private Semaphore semaphore;

    Worker1(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("[ " + Thread.currentThread().getName() + " ] Acquire semaphore...");
            semaphore.acquire();
            Random r = new Random();
            // Gera um número aleatório entre 5000 e 10000
            int sleepTime = r.nextInt((10000 - 5000) + 1) + 5000;
            Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("[ " + Thread.currentThread().getName() + " ] Release semaphore...");
            semaphore.release();
        }
    }
}
