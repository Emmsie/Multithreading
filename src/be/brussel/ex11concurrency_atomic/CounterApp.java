package be.brussel.ex11concurrency_atomic;

public class CounterApp {

    public static void main(String[] args) {

        Counter counter = new Counter();
        Thread thread1 = new Thread(()-> increment(counter, 100));
        Thread thread2 = new Thread(()-> increment(counter, 100));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
        }

        System.out.println(counter.getCount());
    }

    private static void increment(Counter counter, int number){
        for (int i = 0; i<number; i++){
            counter.increment();
        }
    }
}
