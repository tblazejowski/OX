package pl.falcor.ox.io;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class ConsoleReaderTest {

    @Test
    public void shouldReturnTheSameNumberWhenNumberIsProvidedInInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        ConsoleReader consoleReader = new ConsoleReader(new Locale("en", "US"), new Scanner(System.in));

        assertEquals(consoleReader.readNumber(), 2);
    }

    @Test
    public void shouldReturnTheSameTextWhenTextIsProvidedInInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("any text input\n".getBytes());
        System.setIn(inputStream);
        ConsoleReader consoleReader = new ConsoleReader(new Locale("en", "US"), new Scanner(System.in));

        assertEquals(consoleReader.readLine(), "any text input");
    }

    @Test
    public void shouldPrintMessageWithNumberRequestWhenTextIsProvidedFirstTimeInNumberInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("any text input\n2\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        ConsoleReader consoleReader = new ConsoleReader(new Locale("en", "US"), new Scanner(System.in));

        consoleReader.readNumber();

        assertEquals(outputStream.toString(), "Please provide a number.\n");
    }
}