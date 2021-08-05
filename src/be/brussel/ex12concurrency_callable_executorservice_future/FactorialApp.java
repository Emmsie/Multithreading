package be.brussel.ex12concurrency_callable_executorservice_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialApp {

    public static void main(String[] args) {

        int number = 3;

        FactorialCalculator factorialCalculator = new FactorialCalculator(number);
        ExecutorService es = Executors.newSingleThreadExecutor();

        Future<Integer> future = es.submit(factorialCalculator);

        Integer factorial  = null;
        try {
            factorial = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("The factorial of " + number + " is: " + factorial);

        es.shutdown();
    }
}
