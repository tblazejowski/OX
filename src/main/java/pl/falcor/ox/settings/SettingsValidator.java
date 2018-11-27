package pl.falcor.ox.settings;

import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;

import java.util.Locale;

public class SettingsValidator {

    public Locale validateLanguageOption(ConsoleReader consoleReader, ConsolePrinter consolePrinter) {

        int chosenOption = consoleReader.readNumber();
        if (chosenOption == 1) return new Locale("en", "US");
        if (chosenOption == 2) return new Locale("pl", "PL");
        else {
            consolePrinter.println("Please chose option number from the list");
            return validateLanguageOption(consoleReader, consolePrinter);
        }
    }
}