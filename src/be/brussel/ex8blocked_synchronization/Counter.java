package be.brussel.ex8blocked_synchronization;

public class Counter {

    private int count = 0;
//    private Object monitor = new Object();

    // with synchronized methods
    public synchronized void increment(){
        count ++;
    }

    public synchronized void decrement (){
        count--;
    }

    public int getCount(){
        return count;
    }


    // with synchronization blocks using monitor object
//    public void increment (){
//        synchronized (monitor) {
//            count++;
//        }
//    }
//
//    public void decrement (){
//        synchronized (monitor) {
//            count--;
//        }
//    }

    // with synchronization blocks using this
//    public void increment (){
//        synchronized (this) {
//            count++;
//        }
//    }
//
//    public void decrement (){
//        synchronized (this) {
//            count--;
//        }
//    }
}
