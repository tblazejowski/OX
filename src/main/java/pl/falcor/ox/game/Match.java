package pl.falcor.ox.game;

import pl.falcor.ox.arbiter.Arbiter;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.board.Field;
import pl.falcor.ox.board.Sign;
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

    public Sign playMatch() {
        boolean isWon = false;
        consolePrinter.println(settings.getPlayers()[0].getName() + " "
                + messages.getString("kickoffMessage") + " "
                + settings.getPlayers()[0].getSign() + "\n"
                + "\n" + matchBoard.toString());
        while (!isWon) {
            Field chosenField = new Field(requestMove());
            matchBoard.addSign(chosenField, settings.getPlayers()[turn % 2].getSign());
            isWon = arbiter.isWinningSign(chosenField, settings.getPlayers()[turn % 2].getSign());
            printTurnInfo();
            consolePrinter.println(matchBoard.toString());
            turn++;
        }
        return printWinnerInfo();
    }

    private Sign printWinnerInfo() {
        Sign winningSign = arbiter.indicateWhoWon();
        if (winningSign != null) consolePrinter.print(getWinnerName(winningSign) + " " + messages.getString("win") + "  ");
        else consolePrinter.print(messages.getString("draw") + "  ");
        return winningSign;
    }

    private String getWinnerName(Sign sign) {
        String winnerName = "";
        for (Player player : settings.getPlayers()) {
            if (player.getSign().equals(sign)) winnerName = player.getName();
        }
        return winnerName;
    }

    private void printTurnInfo() {
        consolePrinter.println(messages.getString("turn") + " "
                + (turn + 1) + "  ");
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