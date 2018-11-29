package pl.falcor.ox.settings;

import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.game.Player;
import pl.falcor.ox.board.Sign;
import pl.falcor.ox.game.Toogle;
import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;

import java.util.EnumSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SettingsReader implements Toogle {

    private ConsolePrinter consolePrinter;
    private ConsoleReader consoleReader;
    private ResourceBundle messages;
    private final Scanner scanner;
    private Locale currentLocale = new Locale("en", "US");

    Settings requestSettings(){
        Locale currentLocale = setLanguage();
        Player[] players = requestStartingSign(requestWhoStarts(setPlayerNames()));
        BoardDimension boardDimension = requestBoardDimension();
        return new Settings(currentLocale, players, boardDimension);
    }

    public SettingsReader() {
        this.scanner = new Scanner(System.in);
        this.consolePrinter = new ConsolePrinter();
        this.consoleReader = new ConsoleReader(new Locale("en", "US"), scanner);
        this.messages = ResourceBundle.getBundle("MessagesBundle", new Locale("en", "US"));
    }

    public Locale setLanguage() {

        consolePrinter.println(messages.getString("choseLanguage"));
        int chosenOption = validateOptionChosen(Settings.LANGUAGES_NUMBER);
        if (chosenOption == 1) {
            return currentLocale;
        } else {
            currentLocale = new Locale("pl", "PL");
            messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
            scanner.nextLine();
            consoleReader = new ConsoleReader(currentLocale, scanner);
            return currentLocale;
        }
    }

    public String[] setPlayerNames() {

        String[] playerNames = new String[Settings.NUMBER_OF_PLAYERS];
        for (int i = 0; i < Settings.NUMBER_OF_PLAYERS; i++) {
            consolePrinter.println(messages.getString("setNames") + (i + 1));
            playerNames[i] = (consoleReader.readLine());
        }
        return playerNames;
    }

    public String[] requestWhoStarts(String[] playerNames) {

        consolePrinter.println(messages.getString("indicateWhoStarts"));
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
        consolePrinter.println(playerNames[0] + " " + messages.getString("choseSign"));
        EnumSet.allOf(Sign.class).forEach(sign -> consolePrinter.println("[" + (sign.ordinal() + 1) + "] " + sign.toString()));
        int signChosen = validateOptionChosen(Sign.values().length) - 1;
        players[0] = new Player(playerNames[0], Sign.values()[signChosen]);
        if (signChosen == 0) players[1] = new Player(playerNames[1], Sign.values()[1]);
        else players[1] = new Player(playerNames[1], Sign.values()[0]);
        return players;
    }

    public BoardDimension requestBoardDimension() {
        consolePrinter.println(messages.getString("choseDimension"));
        int providedDimension = validateOptionChosen(Settings.MAX_DIMENSION);
        return new BoardDimension(providedDimension);

    }

    public int validateOptionChosen(int availableOptions) {
        int chosenOption = consoleReader.readNumber();
        if (chosenOption > 0 && chosenOption <= availableOptions)
            return chosenOption;
        else {
            consolePrinter.println(messages.getString("errorOption"));
            return validateOptionChosen(availableOptions);
        }
    }
}