package pl.falcor.io;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class ConsoleReaderTest {

    ConsoleReader consoleReader;

    @BeforeClass
    public void initialize() {
        consoleReader = new ConsoleReader();
    }

    @Test
    public void shouldReturnTheSameNumberWhenNumberIsProvidedInInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        Scanner userInput = new Scanner(System.in);


        assertEquals(consoleReader.readNumber(userInput), 2);
    }
}