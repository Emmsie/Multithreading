package be.brussel.ex4daemonthread;

public class PrintCharWithDaemonApp {
    public static void main(String[] args) {

        print('+', 100);

        Thread starThread = new Thread(()->print('*', 100));
        Thread dotThread = new Thread(()->print('.', Integer.MAX_VALUE));

        dotThread.setDaemon(true);

        starThread.start();
        dotThread.start();
    }

    public static void print(char c, int count){
        for (int i = 0; i<count; i++){
            System.out.print(c);
            Thread.yield();
        }
    }
}
