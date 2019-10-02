package EX6;
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

        Barrier barrier = new Barrier(3);
        Worker worker = new Worker(barrier);

        for (int i = 0; i < 6; i++) {
            Thread thread_i = new Thread(worker, "Worker " + i);
            thread_i.start();
        }

    }
}

