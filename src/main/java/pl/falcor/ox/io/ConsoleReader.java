package pl.falcor.ox.io;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Responsible for reading input from console
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class ConsoleReader implements GameReader {

    private Scanner scanner;
    private ConsolePrinter consolePrinter;
    private ResourceBundle messages;

    public ConsoleReader(Locale currentLocale, Scanner scanner) {
        this.scanner = scanner;
        this.consolePrinter = new ConsolePrinter();
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public int readNumber() {

        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            consolePrinter.println(messages.getString("notNumber"));
            scanner.nextLine();
            return readNumber();
        }
    }

    public String readLine() {

        try {
            return scanner.nextLine();
        } catch (InputMismatchException inputMismatchException) {
            consolePrinter.println(messages.getString("unexpected"));
            scanner.nextLine();
            return readLine();
        }
    }
}