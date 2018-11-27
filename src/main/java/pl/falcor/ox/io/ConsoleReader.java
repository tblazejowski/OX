package pl.falcor.ox.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements GameReader {

    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readNumber() {

        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Please provide a number.");
            scanner.nextLine();
            return readNumber();
        }
    }

    public String readLine() {

        try {
            return scanner.nextLine();
        } catch (InputMismatchException inputMismatchException) {
            return readLine();
        }
    }
}