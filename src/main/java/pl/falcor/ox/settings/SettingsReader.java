package pl.falcor.ox.settings;

import pl.falcor.ox.domain.Player;
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

    public Player[] setPlayerNames(int numberOfPlayers) {
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < Settings.NUMBER_OF_PLAYERS; i++) {
            consolePrinter.println("Please provide player" + (i + 1) + " name: ");
            players[i] = new Player(consoleReader.readLine());
        }
        return players;
    }
}