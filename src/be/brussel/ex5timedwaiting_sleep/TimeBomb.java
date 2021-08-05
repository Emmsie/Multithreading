package be.brussel.ex5timedwaiting_sleep;

public class TimeBomb {

    private int timeSeconds;
    private Thread threadActivate;
    boolean disarmedInTime = true;

    public TimeBomb(int time) {
        this.timeSeconds = time;
    }

    public void activate(){
        threadActivate = new Thread(()->printTime(timeSeconds));
        threadActivate.setDaemon(true);
        threadActivate.start();
    }

    public void disarm(){
        printEnding();
    }

    private void printTime (int timeSeconds){
        for (int i = timeSeconds-1; i>=0; i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Timebomb ticking: "+i+ " seconds left..");
        }
        disarmedInTime = false;
    }

    private void printEnding(){
        if (disarmedInTime){
            System.out.println("The bomb is successfully disarmed!!");
            return;
        }
        System.out.println("Boooomm! You exploded :'(");
    }
}
