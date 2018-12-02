package pl.falcor.ox.game;

import pl.falcor.ox.arbiter.Arbiter;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.board.Field;
import pl.falcor.ox.board.Sign;
import pl.falcor.ox.io.ConsolePrinter;
import pl.falcor.ox.io.ConsoleReader;
import pl.falcor.ox.io.GameLogger;
import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

import java.util.ResourceBundle;

/**
 * A {@code Match} object represents a singular match for OX game
 * Match has turns and info about its number in row for specific game {@code Game}
 * Match has its own arbiter {@code Arbiter} and matchBoard on which is played {@code Board}
 * Communication with user is handled by consoleReader {@code ConsoleReader} and
 * consolePrinter {@code ConsolePrinter} via messages {@code ResourceBundle} specified in
 * game settings {@code Settings}
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class Match {

    private Settings settings;
    private ConsoleReader consoleReader;
    private ConsolePrinter consolePrinter;
    private ResourceBundle messages;
    private Board matchBoard;
    private Arbiter arbiter;
    private int matchNumberInRow;
    private int turn = 0;
    private GameLogger gameLogger = new GameLogger();

    /**
     * @param settingsReader transfers channel of communication with user
     * @param settings holds settings for specific match @see Settings
     * @param matchNumberInRow indicates match number in row for specific game {@code Game}
     */
    public Match(SettingsReader settingsReader, Settings settings, int matchNumberInRow) {
        this.settings = settings;
        this.consolePrinter = settingsReader.getConsolePrinter();
        this.consoleReader = settingsReader.getConsoleReader();
        this.messages = settingsReader.getMessages();
        this.matchBoard = new Board(new BoardDimension(settings.getBoardDimension().getDimension()));
        this.arbiter = new Arbiter(matchBoard);
        this.matchNumberInRow = matchNumberInRow;
    }

    /**
     * Plays singular match till finishing conditions are met.
     *
     * @return sign {@code Sign} that won the match.
     */
    Sign playMatch() {
        boolean isWon = false;
        consolePrinter.println(settings.getPlayers()[0].getName() + " "
                + messages.getString("kickoffMessage") + " "
                + settings.getPlayers()[0].getSign() + "\n"
                + "\n" + matchBoard.toString());
        while (!isWon) {
            Field chosenField = new Field(requestMove());
            Sign sign = settings.getPlayers()[turn % 2].getSign();
            matchBoard.addSign(chosenField, sign);
            gameLogger.log("Sign added to game board:" + chosenField + sign);
            isWon = arbiter.isEndingMatchSign(chosenField, sign);
            printTurnInfo();
            consolePrinter.println(matchBoard.toString());
            turn++;
        }
        return printWinnerInfo();
    }

    private Sign printWinnerInfo() {
        Sign winningSign = arbiter.indicateWhoWon();
        if (winningSign != null)
            consolePrinter.print(getWinnerName(winningSign) + " " + messages.getString("win") + "  ");
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
                + (turn + 1) + "  "
                + messages.getString("match") + " " + matchNumberInRow);
    }

    private int requestMove() {
        consolePrinter.println(settings.getPlayers()[turn % 2].getName() + " " + messages.getString("getMove"));
        int providedNumber = consoleReader.readNumber();
        if (providedNumber > 0 && providedNumber <= Math.pow(matchBoard.getBoardDimension().getDimension(), 2)) {
            if (matchBoard.getGameBoard().get(new Field(providedNumber)) != null)  {
                consolePrinter.println(messages.getString("occupied"));
                return requestMove();
            } else return providedNumber;
        } else {
            consolePrinter.println(messages.getString("wrongField"));
            return requestMove();
        }
    }
}