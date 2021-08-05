package be.brussel.ex1extend_threadclass;

public class PrintApp {
    public static void main(String[] args) {
        PrintThread thread = new PrintThread('*', 3);
        thread.start();
    }
}
