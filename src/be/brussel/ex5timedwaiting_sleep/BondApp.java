package be.brussel.ex5timedwaiting_sleep;

import java.util.Random;

public class BondApp {

    public static void main(String[] args) {

        Random rand = new Random();
        TimeBomb bomb = new TimeBomb(10);
        bomb.activate();
        try {
            Thread.sleep(rand.nextInt(13000));
        } catch (InterruptedException e) {
        }
        bomb.disarm();
    }
}
