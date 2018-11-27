package pl.falcor.settings;

import pl.falcor.io.ConsolePrinter;
import pl.falcor.io.ConsoleReader;

import java.util.Locale;

public class SettingsReader {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();

    public Locale setLanguage() {

        consolePrinter.print("Chose language/Wybierz język\n" +
                "[1] English\n" +
                "[2] Polski\n");
        int chosenOption = consoleReader.readNumber();
        if (chosenOption == 1) return new Locale("en", "US");
        else return new Locale("pl", "PL");
    }
}