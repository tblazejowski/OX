package pl.falcor.ox.game;

import pl.falcor.ox.arbiter.Arbiter;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.board.Field;
import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;
import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

import java.util.ResourceBundle;

public class Match {

    private Settings settings;
    private ConsoleReader consoleReader;
    private ConsolePrinter consolePrinter;
    private ResourceBundle messages;
    private Board matchBoard;
    private Arbiter arbiter;
    private int turn = 0;

    public Match(SettingsReader settingsReader, Settings settings) {
        this.settings = settings;
        this.consolePrinter = settingsReader.getConsolePrinter();
        this.consoleReader = settingsReader.getConsoleReader();
        this.messages = settingsReader.getMessages();
        this.matchBoard = new Board(new BoardDimension(settings.getBoardDimension().getDimension()));
        this.arbiter = new Arbiter(matchBoard);
    }

    public void playMatch() {
        boolean isWon = false;
        consolePrinter.println(settings.getPlayers()[0].getName() + " "
                + messages.getString("kickoffMessage") + " "
                + settings.getPlayers()[0].getSign() + "\n"
                + "\n" + matchBoard.toString());
        while (!isWon) {
            Field chosenField = new Field(requestMove());
            matchBoard.addSign(chosenField, settings.getPlayers()[turn % 2].getSign());
            isWon = arbiter.isWinningSign(chosenField, settings.getPlayers()[turn % 2].getSign());
            consolePrinter.println(matchBoard.toString());
            turn++;
        }
    }

    private int requestMove() {
        consolePrinter.println(settings.getPlayers()[turn % 2].getName() + " " + messages.getString("getMove"));
        int providedNumber = consoleReader.readNumber();
        if (providedNumber > 0 && providedNumber <= Math.pow(matchBoard.getBoardDimension().getDimension(), 2)) {
            return providedNumber;
        } else {
            consolePrinter.println(messages.getString("wrongField"));
            return requestMove();
        }
    }
}