package pl.falcor.ox.game;

import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

public class Game {

    private static final int NUMBER_OF_MATCHES = 1;
    private Settings settings;

    public Settings getSettings() {
        return settings;
    }

    public void initializeGame() {
        SettingsReader settingsReader = new SettingsReader();
        settings = settingsReader.requestSettings();
        Match match = new Match(settingsReader, settings);
        match.playMatch();
    }
}