package pl.falcor.ox.io;

public class ConsolePrinter implements GamePrinter {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }
}