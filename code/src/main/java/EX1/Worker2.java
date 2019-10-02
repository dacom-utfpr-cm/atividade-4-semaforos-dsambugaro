package EX1;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX1
 *
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Worker2 implements Runnable {

    private Semaphore semaphore;

    Worker2(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {

            Random r = new Random();
            // Gera um número aleatório entre 1000 e 3000
            int sleepTime = r.nextInt((3000 - 1000) + 1) + 1000;
            Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

            System.out.println("[ " + Thread.currentThread().getName() + " ] Waiting for T1...");
            semaphore.acquire();
            System.out.println("[ " + Thread.currentThread().getName() + " ] Getting T1 signaling");
            System.out.println("[ " + Thread.currentThread().getName() + " ] It's all, bye bye");

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            semaphore.release();
        }
    }
}
