package pl.falcor.ox.settings;

import pl.falcor.ox.domain.Player;
import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;

import java.util.Locale;

public class SettingsReader {

    private ConsolePrinter consolePrinter;
    private ConsoleReader consoleReader;

    public SettingsReader() {
        this.consolePrinter = new ConsolePrinter();
        this.consoleReader = new ConsoleReader();
    }

    public Locale setLanguage() {

        consolePrinter.println("Chose language/Wybierz język\n" +
                "[1] English\n" +
                "[2] Polski");
        int chosenOption = consoleReader.readNumber();
        if (chosenOption == 1) return new Locale("en", "US");
        if (chosenOption == 2) return new Locale("pl", "PL");
        else {
            consolePrinter.println("Please chose option number from the list");
            return setLanguage();
        }
    }

    public String[] setPlayerNames(int numberOfPlayers) {

        String[] playerNames = new String[numberOfPlayers];
        for (int i = 0; i < Settings.NUMBER_OF_PLAYERS; i++) {
            consolePrinter.println("Please provide player" + (i + 1) + " name: ");
            playerNames[i] = (consoleReader.readLine());
        }
        return playerNames;
    }


}