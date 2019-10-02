package EX6;
/*
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX6
 *
 */

import java.util.concurrent.Semaphore;

public class Barrier {

    private int max;
    private int qtThreads;
    private Semaphore mutex = new Semaphore(1);
    private boolean logicalSwitch = false;
    private Semaphore barrier1 = new Semaphore(1);
    private Semaphore barrier2 = new Semaphore(1);


    Barrier(int max) {
        this.max = max;
        try {
            barrier1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            barrier1.release();
        }
    }

    public void getBarrier() throws InterruptedException {
        mutex.acquire();
        qtThreads++;
        int qtThreads = this.qtThreads;
        mutex.release();

        if (qtThreads >= max) {
            if (!logicalSwitch) {
                mutex.acquire();
                this.qtThreads = 0;
                logicalSwitch = !logicalSwitch;
                mutex.release();
                barrier1.release();
                barrier2.acquire();
            } else {
                mutex.acquire();
                this.qtThreads = 0;
                logicalSwitch = !logicalSwitch;
                mutex.release();
                barrier2.release();
                barrier1.acquire();
            }
        } else {
            if (!logicalSwitch) {
                barrier1.acquire();
                barrier1.release();
            } else {
                barrier2.acquire();
                barrier2.release();
            }
        }
    }
}
