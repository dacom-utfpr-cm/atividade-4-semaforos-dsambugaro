package EX3;
/*
 * Exercicio 3
 * Garantir acesso exclusivo à seção crítica. Faça um código que possibilite que 2 ou mais threads realizem o
 * incremento de um contador. Faça aexclusão mútua com semáforo.
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX3
 *
 */

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Contador contador = new Contador();

        Increment increment = new Increment(semaphore, contador);

        for (int i = 0; i < 5; i++) {
            Thread thread_i = new Thread(increment, "Thread " + i);
            thread_i.start();
        }

    }
}
