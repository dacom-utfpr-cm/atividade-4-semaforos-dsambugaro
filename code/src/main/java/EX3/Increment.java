package EX3;
/*
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX3
 *
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Increment implements Runnable {

    private Semaphore semaphore;
    private Contador contador;

    Increment(Semaphore semaphore, Contador contador) {
        this.semaphore = semaphore;
        this.contador = contador;
    }

    private void increment(){
        try {
            semaphore.acquire();
            contador.increment();
            Random r = new Random();
            // Gera um número aleatório entre 5000 e 10000
            int sleepTime = r.nextInt((10000 - 5000) + 1) + 5000;
            Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos
            System.out.println("[ " + Thread.currentThread().getName() + " ] Incremented value to " + contador.getValue());
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
