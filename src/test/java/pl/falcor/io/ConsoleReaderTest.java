package pl.falcor.io;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

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

        assertEquals(consoleReader.readNumber(), 2);
    }

    @Test
    public void shouldReturnTheTextWhenTextIsProvidedInInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("any text input\n".getBytes());
        System.setIn(inputStream);

        assertEquals(consoleReader.readLine(), "any text input");
    }
}