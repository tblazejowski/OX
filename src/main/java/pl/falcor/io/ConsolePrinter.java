package pl.falcor.io;

public class ConsolePrinter implements GamePrinter {

    public void print(String message) {
        System.out.println(message);
    }
}
