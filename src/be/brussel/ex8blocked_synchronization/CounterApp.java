package be.brussel.ex8blocked_synchronization;

public class CounterApp {
    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread thread1 = new Thread(()-> increment(counter, 10000));
        Thread thread2 = new Thread(()-> increment(counter, 10000));
        Thread thread3 = new Thread(()-> decrement(counter, 20000));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
        }

        System.out.println(counter.getCount());

    }

    private static void  increment(Counter counter, int number){
        for (int i = 0; i<number; i++){
            counter.increment();
        }
    }

    private static void  decrement(Counter counter, int number){
        for (int i = 0; i<number; i++){
            counter.decrement();
        }
    }
}
