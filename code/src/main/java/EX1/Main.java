package EX1;
/*
 * Exercicio 1
 * Enviar sinal para outra thread para indicar que um evento ocorreu.
 * Faça um código que uma thread t1 e t2 são inicializadas simultaneamente, mas a t2 pode somente
 * continuar a execução após a sinalização de t1.
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX1
 *
 */

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Worker1 worker1 = new Worker1(semaphore);
        Worker2 worker2 = new Worker2(semaphore);

        Thread t1 = new Thread(worker1, "T1");
        Thread t2 = new Thread(worker2, "T2");

        t1.start();
        t2.start();

    }
}
