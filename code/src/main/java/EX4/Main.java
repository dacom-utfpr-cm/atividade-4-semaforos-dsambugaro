package EX4;
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
        int N = 3;
        Semaphore semaphore = new Semaphore(N);
        CriticalRegion criticalRegion = new CriticalRegion();

        AccessCritialRegion accessCritialRegion = new AccessCritialRegion(semaphore, criticalRegion);

        for (int i = 0; i < 10; i++) {
            Thread thread_i = new Thread(accessCritialRegion, "Thread " + i);
            thread_i.start();
        }

    }
}
