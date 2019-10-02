package EX7;
/*
 *
 * @author Danilo Sambugaro created on 01/10/2019 inside the package - EX5
 *
 */

public class Worker2 implements Runnable {

    private Queue queue;

    Worker2(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            System.out.println("[ " + Thread.currentThread().getName() + " ] Waiting on queue 2...");
            queue.enterQueueTwo();
            System.out.println("[ " + Thread.currentThread().getName() + " ] Passing through queue 2...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
