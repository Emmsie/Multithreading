package be.brussel.ex10schedule_timer_timertask;

import java.util.Timer;

public class TimeoutApp {

    public static void main(String[] args) {

        Timeout task = new Timeout();
        Timer timer = new Timer(true);
        // perform task after 10 sec
        timer.schedule(task, 1000*10);

        System.out.println("Please wait..");
        // allow enough time to perform the task
        try{
            Thread.sleep(1000*20);
        } catch (InterruptedException ie){
        }
    }
}
