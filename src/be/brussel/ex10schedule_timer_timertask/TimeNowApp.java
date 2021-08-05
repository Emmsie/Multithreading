package be.brussel.ex10schedule_timer_timertask;

import java.util.Timer;

public class TimeNowApp {
    public static void main(String[] args) {
        TimeNow now= new TimeNow();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(now, 0, 1000);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException ie) {
        }
    }
}
