package EX5;
/*
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX5
 *
 */

import java.util.concurrent.Semaphore;

public class Barrier {

    private int max;
    private int qtThreads;
    private Semaphore mutex = new Semaphore(1);;
    private Semaphore barrier = new Semaphore(1);;

    Barrier(int max){
        this.max = max;
        try {
            barrier.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            barrier.release();
        }
    }

    public void getBarrier() throws InterruptedException {
        mutex.acquire();
        qtThreads++;
        int qtThreads = this.qtThreads;
        mutex.release();
        if (qtThreads >= max){
            barrier.release();
        } else {
            barrier.acquire();
            barrier.release();
        }
    }
}
