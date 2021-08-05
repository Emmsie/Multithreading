package be.brussel.ex2implement_runnable;

public class PrintCharApp {
    public static void main(String[] args) {

        CharacterPrinter print3Stars = new CharacterPrinter('*', 3);
        CharacterPrinter print10Dots = new CharacterPrinter('.', 10);

        Thread starThread = new Thread(print3Stars);
        Thread dotThread = new Thread(print10Dots);

        starThread.start();
        dotThread.start();
    }
}
