package pl.falcor.ox.settings;

import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;

import java.util.Locale;

public class SettingsReader {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();
    private SettingsValidator settingsValidator = new SettingsValidator();

    public Locale setLanguage() {

        consolePrinter.println("Chose language/Wybierz język\n" +
                "[1] English\n" +
                "[2] Polski");

        return settingsValidator.validateLanguageOption(consoleReader, consolePrinter);
    }
}