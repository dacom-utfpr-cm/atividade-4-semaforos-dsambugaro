package EX7;
/*
 *
 * @author Danilo Sambugaro created on 01/10/2019 inside the package - EX5
 *
 */

public class Worker implements Runnable {

    private Queue queue;

    Worker(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            System.out.println("[ " + Thread.currentThread().getName() + " ] Waiting on queue 1...");
            queue.enterQueueOne();
            System.out.println("[ " + Thread.currentThread().getName() + " ] Passing through queue 1...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
