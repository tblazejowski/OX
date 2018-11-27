package pl.falcor.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements GameReader {

    public int readNumber() {

        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            scanner.nextLine();
            return readNumber();
        }
    }

    public String readLine() {

        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextLine();
        } catch (InputMismatchException inputMismatchException) {
            return readLine();
        }
    }
}