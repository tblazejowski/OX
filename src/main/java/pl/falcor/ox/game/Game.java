package pl.falcor.ox.game;

import pl.falcor.ox.settings.Settings;
import pl.falcor.ox.settings.SettingsReader;

public class Game {

    private Settings settings;

    public Settings getSettings() {
        return settings;
    }

    void initializeGame(){
        SettingsReader settingsReader = new SettingsReader();
        settings = settingsReader.requestSettings();
    }
}
