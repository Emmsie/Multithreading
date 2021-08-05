package be.brussel.ex10schedule_timer_timertask;

import java.util.TimerTask;

public class Timeout extends TimerTask {
    @Override
    public void run() {
        System.out.println("The time is out");
    }
}
