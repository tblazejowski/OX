package pl.falcor.ox.game;

import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

public class Game {

    private static final int NUMBER_OF_MATCHES = 3;
    private Settings settings;
    private SettingsReader settingsReader;

    public Settings getSettings() {
        return settings;
    }

    public void start() {
        initializeGame();
        Match match = new Match(settingsReader, settings);
        match.playMatch();
    }

    void initializeGame() {
        settingsReader = new SettingsReader();
        settings = settingsReader.requestSettings();
    }
}