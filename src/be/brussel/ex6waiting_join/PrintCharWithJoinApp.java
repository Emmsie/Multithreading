package be.brussel.ex6waiting_join;

public class PrintCharWithJoinApp {

    public static void main(String[] args){

        Thread starThread = new Thread(()->print('*', 100));
        Thread dotThread = new Thread(()-> print('.', 200));

        starThread.start();
        dotThread.start();

        try{
            starThread.join();
            dotThread.join(2000); // timed waiting
        } catch (InterruptedException ie){
        }

        System.out.println("End");
    }

    private static  void print (char c , int count){
        for(int i = 0; i < count; i++){
            System.out.print(c);
            try{
                Thread.sleep(100);
            } catch (InterruptedException ie){
            }
        }
    }
}
