package EX7;
/*
 * Exercicio 5
 * Após N threads sincronizarem em um ponto em comum, um trecho específico (ponto crítico) pode ser executado por
 * cada uma delas.Faça um código que possibilite barrar N threads em um ponto específico de execução e, após todas
 * alcançarem o ponto, todas devem executar o trecho de código após esse ponto.
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX5
 *
 */

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue();
        Worker worker = new Worker(queue);
        Worker2 worker2 = new Worker2(queue);

        for (int i = 0; i < 6; i++) {
            Thread workerThread = new Thread(worker, "Q1 - " + i);
            Thread workerThread2 = new Thread(worker2, "Q2 - " + i);
            workerThread.start();
            workerThread2.start();
        }

    }
}

