package EX2;
/*
 * Exercicio 2
 * Enviar sinalização para um ponto de encontro entre threads.Faça um código que uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa.
 * Exemplo:
 * t1:
 * - trecho1.1
 * - trecho1.2
 * t2:
 * - trecho2.1
 * - trecho2.2
 * thecho1.1 ocorre antes trecho2.2 e threcho2.1 ocorre antes de trecho1.2.
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX2
 *
 */

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        Worker1 worker1 = new Worker1(semaphore1, semaphore2);
        Worker2 worker2 = new Worker2(semaphore1, semaphore2);

        Thread t1 = new Thread(worker1, "T1");
        Thread t2 = new Thread(worker2, "T2");

        t1.start();
        t2.start();
    }
}
