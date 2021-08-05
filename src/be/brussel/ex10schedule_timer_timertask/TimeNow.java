package be.brussel.ex10schedule_timer_timertask;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class TimeNow extends TimerTask {

    private LocalTime localTime;

    @Override
    public void run() {
        localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(localTime.format(formatter));
    }
}
