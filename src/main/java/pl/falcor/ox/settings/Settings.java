package pl.falcor.ox.settings;

import java.util.Locale;

public class Settings {

    public static final int NUMBER_OF_PLAYERS = 2;
    private final Locale gameLocale;

    public Settings() {
        gameLocale = new Locale("en", "US");
        Locale.setDefault(this.gameLocale);
    }

    public Settings(Locale gameLocale) {
        this.gameLocale = gameLocale;
        Locale.setDefault(this.gameLocale);
    }

    public Locale getGameLocale() {
        return gameLocale;
    }
}