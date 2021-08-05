package be.brussel.ex7nosynchronization;

public class Counter {

    private int count = 0;

    public void increment(){
        count ++;
    }

    public void decrement (){
        count--;
    }

    public int getCount(){
        return count;
    }
}
