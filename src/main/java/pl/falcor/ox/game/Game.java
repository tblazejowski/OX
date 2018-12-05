package pl.falcor.ox.game;

import pl.falcor.ox.board.Sign;
import pl.falcor.ox.io.GameLogger;
import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

import java.util.ResourceBundle;

/**
 * A {@code Game} object represents a OX game
 * Game consist of specified NUMBER_OF_MATCHES matches {@code Match}
 * and has stipulated POINTS_FOR_WIN and POINTS_FOR_DRAW
 * Game has its settings {@code Settings} and score {@code Score}
 * It has also its bundle of messages to communicate with user {@code ResourceBundle}
 * in chosen language
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class Game implements Toogle {

    private static final int NUMBER_OF_MATCHES = 3;
    private static final int POINTS_FOR_DRAW = 1;
    private static final int POINTS_FOR_WIN = 3;
    private final ResourceBundle messages;
    private final Settings settings;
    private final SettingsReader settingsReader;
    private final Score score;
    private GameLogger gameLogger = new GameLogger();

    public Game() {
        settingsReader = new SettingsReader();
        settings = settingsReader.requestSettings();
        messages = settingsReader.getMessages();
        score = new Score(settings.getPlayers().length);
    }

    Settings getSettings() {
        return settings;
    }

    /**
     * Creates object of type {@code Match} and plays matches
     * till NUMBER_OF_MATCHES constance
     */
    public void start() {
        int matchNumberInRow = 1;
        gameLogger.log("Game started: " + settings);

        while (matchNumberInRow <= NUMBER_OF_MATCHES) {
            Match match = new Match(settingsReader, settings, matchNumberInRow);
            setScore(match.playMatch());
            printScore(matchNumberInRow);
            matchNumberInRow++;
            swapObjectsInArray(settings.getPlayers());
        }
    }

    private void setScore(Sign sign) {
        if (sign == null) {
            score.getScore()[0] = score.getScore()[0] + POINTS_FOR_DRAW;
            score.getScore()[1] = score.getScore()[1] + POINTS_FOR_DRAW;
        } else if (sign.equals(Sign.X)) score.getScore()[1] = score.getScore()[1] + POINTS_FOR_WIN;
        else score.getScore()[0] = score.getScore()[0] + POINTS_FOR_WIN;
    }

    private void printScore(int matchesToPlay) {
        StringBuilder scoreMessage = new StringBuilder();
        if (matchesToPlay == NUMBER_OF_MATCHES) {
            printFinalWinnerInfo();
            scoreMessage.append(messages.getString("finalScore")
                    + " O: "
                    + score.getScore()[0]
                    + "; X: "
                    + score.getScore()[1]);
            settingsReader.getConsolePrinter().println(scoreMessage.toString());
            gameLogger.log(scoreMessage.toString());
        } else {
            scoreMessage.append(messages.getString("score")
                    + " O: "
                    + score.getScore()[0]
                    + "; X: "
                    + score.getScore()[1]);
            settingsReader.getConsolePrinter().println(scoreMessage.toString());
            gameLogger.log(scoreMessage.toString());
        }
    }

    private void printFinalWinnerInfo() {
        if (score.getScore()[0] == score.getScore()[1])
            settingsReader.getConsolePrinter().print("\n" + messages.getString("finalDraw") + "  ");
        else if (score.getScore()[0] > score.getScore()[1]) {
            settingsReader.getConsolePrinter().print("\n" + getWinnerName(Sign.O) + " " + messages.getString("finalWin") + "  ");
        } else
            settingsReader.getConsolePrinter().print("\n" + getWinnerName(Sign.X) + " " + messages.getString("finalWin") + "  ");
    }

    private String getWinnerName(Sign sign) {
        String winnerName = "";
        for (Player player : settings.getPlayers()) {
            if (player.getSign().equals(sign)) winnerName = player.getName();
        }
        return winnerName;
    }
}