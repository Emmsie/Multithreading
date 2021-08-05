package be.brussel.ex9waitandnotify_synchronization;

public class Calculator {

    private int value = 0;
    private int result = 0;
    private boolean done = true;
    private boolean busy = false;
    private Thread t;
    private String treadControl;

    public Calculator(){
        Thread thread = new Thread(this::calculate);
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void setValue(int value){

        while(busy){
            try{
                wait();
            } catch (InterruptedException e){
            }
        }
        this.value = value;
        done = false;
        busy = true;
        // check if thread that sets value and thread that gets value correspond
        System.out.print("The initial value " + value + " is set by " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized int getResult(){

        while(!done){
            try{
                wait();
            } catch (InterruptedException e){
            }
        }

        busy = false;
        // check if thread that sets value and thread that gets value correspond
        System.out.println( ", the calculate value "+ result +" is returned by " + Thread.currentThread().getName() + ".");
        notifyAll();
        return result;
    }

    private synchronized void calculate() {

        while(true){
            while(done){
                try{
                    wait();
                } catch (InterruptedException e){
                }
            }
            result = value * value;
            done = true;
            notifyAll();
        }
    }

}