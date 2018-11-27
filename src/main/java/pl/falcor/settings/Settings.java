package pl.falcor.settings;

import java.util.Locale;

public class Settings {

    private final Locale gameLocale;

    public Settings() {
        gameLocale = new Locale("en", "US");
        Locale.setDefault(gameLocale);
    }

    public Locale getGameLocale() {
        return gameLocale;
    }
}