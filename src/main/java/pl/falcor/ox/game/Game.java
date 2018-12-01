package pl.falcor.ox.game;

import pl.falcor.ox.board.Sign;
import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

import java.util.ResourceBundle;

public class Game {

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
        Match match = new Match(settingsReader, settings);
        setScore(match.playMatch());
        printScore();
    }

    private void setScore(Sign sign) {
        if (sign == null) {
            score.getScore()[0] =+ POINTS_FOR_DRAW;
            score.getScore()[1] =+ POINTS_FOR_DRAW;
        } else if (sign.equals(Sign.X)) score.getScore()[1] =+ POINTS_FOR_WIN;
        else score.getScore()[0] =+ POINTS_FOR_WIN;
    }

    private void printScore() {
        settingsReader.getConsolePrinter().println(messages.getString("score") + " O: "
                + score.getScore()[0]
                + "; X: "
                + score.getScore()[1]);
    }
}