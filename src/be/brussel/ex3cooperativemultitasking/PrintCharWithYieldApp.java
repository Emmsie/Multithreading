package be.brussel.ex3cooperativemultitasking;

public class PrintCharWithYieldApp {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        print('+', 100);

        Thread starThread = new Thread(()->print('*', 100));
        Thread dotThread = new Thread(()->print('.', 100));

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
