package pl.falcor.ox.settings;

import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.domain.Player;

import java.util.Locale;

public class Settings {

    public static final int NUMBER_OF_PLAYERS = 2;
    public static final int MAX_DIMENSION = 9;
    public static final int LANGUAGES_NUMBER = 2;
    private final Locale gameLocale;
    private Player[] players;
    private BoardDimension boardDimension;

    public Settings() {
        gameLocale = new Locale("en", "US");
        Locale.setDefault(this.gameLocale);
    }

    public Settings(Locale gameLocale, Player[] players, BoardDimension boardDimension) {
        this.gameLocale = gameLocale;
        Locale.setDefault(this.gameLocale);
        this.players = players;
        this.boardDimension = boardDimension;
    }

    public Locale getGameLocale() {
        return gameLocale;
    }

    public Player[] getPlayers() {
        return players;
    }

    public BoardDimension getBoardDimension() {
        return boardDimension;
    }
}