package pl.falcor.ox.settings;

import pl.falcor.ox.domain.Player;

import java.util.Locale;

public class Settings {

    public static final int NUMBER_OF_PLAYERS = 2;
    public static final int MAX_DIMENSION = 9;
    private final Locale gameLocale;
    private Player[] players;

    public Settings() {
        gameLocale = new Locale("en", "US");
        Locale.setDefault(this.gameLocale);
    }

    public Settings(Locale gameLocale, Player[] players) {
        this.gameLocale = gameLocale;
        Locale.setDefault(this.gameLocale);
        this.players = players;
    }

    public Locale getGameLocale() {
        return gameLocale;
    }

    public Player[] getPlayers() {
        return players;
    }
}