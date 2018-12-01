package pl.falcor.ox.game;

import pl.falcor.ox.board.Sign;
import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

import java.util.ResourceBundle;

public class Game implements Toogle {

    private ResourceBundle messages;
    private static final int NUMBER_OF_MATCHES = 3;
    private static final int POINTS_FOR_DRAW = 1;
    private static final int POINTS_FOR_WIN = 3;
    private Settings settings;
    private SettingsReader settingsReader;
    private Score score;

    public Game() {
        settingsReader = new SettingsReader();
        settings = settingsReader.requestSettings();
        messages = settingsReader.getMessages();
        score = new Score(settings.getPlayers().length);
    }

    public Settings getSettings() {
        return settings;
    }

    public void start() {
        int matchNumberInRow = 1;
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
        if (matchesToPlay == NUMBER_OF_MATCHES) {
            printFinalWinnerInfo();
            settingsReader.getConsolePrinter().println(messages.getString("finalScore")
                    + " O: "
                    + score.getScore()[0]
                    + "; X: "
                    + score.getScore()[1]);
        } else
            settingsReader.getConsolePrinter().println(messages.getString("score")
                    + " O: "
                    + score.getScore()[0]
                    + "; X: "
                    + score.getScore()[1]);
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