package EX7;
/*
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX7
 *
 */

import java.util.concurrent.Semaphore;

public class Queue {

    private int qtQueueOne;
    private int qtQueueTwo;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore barrier1 = new Semaphore(1);
    private Semaphore barrier2 = new Semaphore(1);


    Queue() {
        try {
            barrier1.acquire();
            barrier2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            barrier1.release();
            barrier2.release();
        }
    }

    public void enterQueueOne() throws InterruptedException {
        mutex.acquire();
        qtQueueOne++;
        int qtQueueOne = this.qtQueueOne;
        int qtQueueTwo = this.qtQueueTwo;
        mutex.release();

        if (qtQueueOne >= 0 && qtQueueTwo >= 0) {
            mutex.acquire();
            this.qtQueueOne = --this.qtQueueOne == 0 ? 0 : this.qtQueueOne;
            this.qtQueueTwo = --this.qtQueueTwo == 0 ? 0 : this.qtQueueTwo;
            barrier1.release();
            barrier2.release();
            barrier1.acquire();
            mutex.release();
        } else {
            barrier1.acquire();
            barrier1.release();
        }
    }

    public void enterQueueTwo() throws InterruptedException {
        mutex.acquire();
        qtQueueTwo++;
        int qtQueueOne = this.qtQueueOne;
        int qtQueueTwo = this.qtQueueTwo;
        mutex.release();

        if (qtQueueOne >= 0 && qtQueueTwo >= 0) {
            mutex.acquire();
            this.qtQueueOne = --this.qtQueueOne == 0 ? 0 : this.qtQueueOne;
            this.qtQueueTwo = --this.qtQueueTwo == 0 ? 0 : this.qtQueueTwo;
            barrier1.release();
            barrier2.release();
            barrier2.acquire();
            mutex.release();
        } else {
            barrier2.acquire();
            barrier2.release();
        }
    }

}
