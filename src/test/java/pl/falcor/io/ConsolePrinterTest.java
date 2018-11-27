package pl.falcor.io;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class ConsolePrinterTest {

    @Test
    public void shouldPrintProvidedParameterOnTheConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ConsolePrinter consolePrinter = new ConsolePrinter();

        consolePrinter.print("any text message");

        assertEquals(outputStream.toString(), "any text message\n");
    }
}