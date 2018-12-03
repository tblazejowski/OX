package pl.falcor.ox.io;

/**
 * Responsible for output on console
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class ConsolePrinter implements GamePrinter {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }
}