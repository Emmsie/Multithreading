package be.brussel.ex12concurrency_callable_executorservice_future;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {

    private int number;

    public FactorialCalculator(int number) {
        if(number<0){
            throw new IllegalArgumentException("You can't calculate the factorial of a number smaller than 0.");
        }
        this.number = number;
    }

    @Override
    public Integer call()  {
        int factorial = 1;
        for(int i= 2; i<=number; i++){
            factorial *= i;
        }
        return factorial;
    }
}
