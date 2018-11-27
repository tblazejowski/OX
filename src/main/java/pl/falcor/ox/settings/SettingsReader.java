package pl.falcor.ox.settings;

import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;

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
        if (chosenOption == 2) return new Locale("pl", "PL");
        else {
            consolePrinter.print("Chose option number from the list\n");
            return setLanguage();
        }
    }
}