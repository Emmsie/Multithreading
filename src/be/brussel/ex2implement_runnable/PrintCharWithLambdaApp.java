package be.brussel.ex2implement_runnable;

public class PrintCharWithLambdaApp {

    public static void main(String[] args) {

        print('+', 100);

        Thread starThread = new Thread(()->print('*', 100));
        Thread dotThread = new Thread(()->print('.', 100));

        starThread.start();
        dotThread.start();
    }

    public static void print(char c, int count){
        for (int i = 0; i<count; i++){
            System.out.print(c);
        }
    }
}
