package pl.falcor.ox.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements GameReader {

    private final Scanner scanner;
    private final ConsolePrinter consolePrinter;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
        this.consolePrinter = new ConsolePrinter();
    }

    public int readNumber() {

        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            consolePrinter.println("Please provide a number.");
            scanner.nextLine();
            return readNumber();
        }
    }

    public String readLine() {

        try {
            return scanner.nextLine();
        } catch (InputMismatchException inputMismatchException) {
            consolePrinter.println("Something went wrong please try again: ");
            scanner.nextLine();
            return readLine();
        }
    }
}