package EX4;
/*
 *
 * @author Danilo Sambugaro created on 30/09/2019 inside the package - EX3
 *
 */

public class CriticalRegion {

    public void getCriticalRegion(){
        System.out.println("[ "+ Thread.currentThread().getName() +" ] Acessando região crítica e.e");
    }
    
}
