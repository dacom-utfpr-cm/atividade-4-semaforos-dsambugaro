package EX2;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX1
 *
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Worker2 implements Runnable {

    private Semaphore semaphore1;
    private Semaphore semaphore2;

    Worker2(Semaphore semaphore1, Semaphore semaphore2) {
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
    }

    @Override
    public void run() {
        try {
            semaphore2.acquire();
            System.out.println("[ Page 2.1 ]");
            Random r = new Random();
            // Gera um número aleatório entre 5000 e 10000
            int sleepTime = r.nextInt((10000 - 5000) + 1) + 5000;
            Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore2.release();
        }

        try {
            semaphore1.acquire();
            System.out.println("[ Page 2.2 ]");
            Random r = new Random();
            // Gera um número aleatório entre 5000 e 10000
            int sleepTime = r.nextInt((10000 - 5000) + 1) + 5000;
            Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore1.release();
        }
    }
}
