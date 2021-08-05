package be.brussel.ex5timedwaiting_sleep;

public class PrintCharWithSleepApp {
    public static void main(String[] args) throws InterruptedException {

        print('+', 100);

        Thread starThread = new Thread(()->print('*', 100));
        Thread dotThread = new Thread(()-> print('.', 200));

        starThread.setName("StarThread");
        dotThread.setName("DotThread");

        starThread.start();
        dotThread.start();

//        Thread.sleep(470);
        starThread.interrupt();
//        Thread.sleep(1300);
        dotThread.interrupt();
    }

    private static void print(char c, int count){
        for (int i = 0; i<count; i++){
            System.out.println(c);
            try{
                Thread.sleep(100);
            } catch (InterruptedException ie){
                System.out.println(Thread.currentThread().getName()+": interrupted");
            }
        }
    }
}
