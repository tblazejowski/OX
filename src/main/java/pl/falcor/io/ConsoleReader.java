package pl.falcor.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements GameReader {

    @Override
    public int readNumber(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            return readNumber(scanner);
        }
    }
}