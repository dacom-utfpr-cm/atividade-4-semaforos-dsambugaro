package EX5;
/*
 *
 * @author Danilo Sambugaro created on 01/10/2019 inside the package - EX5
 *
 */

import java.util.concurrent.Semaphore;

public class Worker implements Runnable {

    private Barrier barrier;

    Worker(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {

        try {
            System.out.println("[ " + Thread.currentThread().getName() + " ] Waiting on barrier...");
            barrier.getBarrier();
            System.out.println("[ " + Thread.currentThread().getName() + " ] Passing through barrier...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
