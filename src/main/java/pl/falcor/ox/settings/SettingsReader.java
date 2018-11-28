package pl.falcor.ox.settings;

import pl.falcor.ox.domain.BoardDimension;
import pl.falcor.ox.domain.Player;
import pl.falcor.ox.domain.Sign;
import pl.falcor.ox.domain.Toogle;
import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;

import java.util.EnumSet;
import java.util.Locale;

public class SettingsReader implements Toogle {

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

    public String[] setPlayerNames() {

        String[] playerNames = new String[Settings.NUMBER_OF_PLAYERS];
        for (int i = 0; i < Settings.NUMBER_OF_PLAYERS; i++) {
            consolePrinter.println("Please provide player" + (i + 1) + " name: ");
            playerNames[i] = (consoleReader.readLine());
        }
        return playerNames;
    }

    public String[] requestWhoStarts(String[] playerNames) {

        consolePrinter.println("Please indicate who starts:");
        for (int i = 0; i < Settings.NUMBER_OF_PLAYERS; i++) {
            consolePrinter.println("[" + (i + 1) + "] " + playerNames[i]);
        }
        if (validateOptionChosen(Settings.NUMBER_OF_PLAYERS) - 1 == 0) return playerNames;
        else {
            swapObjectsInArray(playerNames);
            return playerNames;
        }
    }

    public Player[] requestStartingSign(String[] playerNames) {

        Player[] players = new Player[Settings.NUMBER_OF_PLAYERS];
        consolePrinter.println(playerNames[0] + " please chose your sign:");
        EnumSet.allOf(Sign.class).forEach(sign -> consolePrinter.println("[" + (sign.ordinal() + 1) + "] " + sign.toString()));
        int signChosen = validateOptionChosen(Sign.values().length) - 1;
        players[0] = new Player(playerNames[0], Sign.values()[signChosen]);
        if (signChosen == 0) players[1] = new Player(playerNames[1], Sign.values()[1]);
        else players[1] = new Player(playerNames[1], Sign.values()[0]);
        return players;
    }

    public BoardDimension requestBoardDimension(){
        consolePrinter.println("Please provide board dimension");
        int providedDimension = validateOptionChosen(Settings.MAX_DIMENSION);
        return new BoardDimension(providedDimension);

    }

    public int validateOptionChosen(int availableOptions) {
        int chosenOption = consoleReader.readNumber();
        if (chosenOption > 0 && chosenOption <= availableOptions)
            return chosenOption;
        else return validateOptionChosen(availableOptions);
    }
}