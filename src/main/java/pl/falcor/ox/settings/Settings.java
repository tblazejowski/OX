package pl.falcor.ox.settings;

import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.game.Player;

import java.util.Arrays;
import java.util.Locale;

/**
 * A {@code Settings} wraps all settings needed for OX game
 *
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class Settings {

    /**
     * indicates number of total players participating in OX game
     */
    static final int NUMBER_OF_PLAYERS = 2;
    /**
     * indicates maximum dimension of board {@code BoardDimension} to play on
     */
    static final int MAX_DIMENSION = 9;
    /**
     *indicates number of languages used in game
     */
    static final int LANGUAGES_NUMBER = 2;
    private final Locale gameLocale;
    private Player[] players;
    private BoardDimension boardDimension;

    Settings() {
        gameLocale = new Locale("en", "US");
        Locale.setDefault(this.gameLocale);
    }

    /**
     * constructor for creating game settings on basis of provided params
     *
     * @param gameLocale indicates specific Locale for a game
     * @param players array of Players that participate in a game
     * @param boardDimension indicates dimension of board for game
     */
    Settings(Locale gameLocale, Player[] players, BoardDimension boardDimension) {
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

    @Override
    public String toString() {
        return "Settings{" +
                "gameLocale=" + gameLocale +
                ", players=" + Arrays.toString(players) +
                ", boardDimension=" + boardDimension +
                '}';
    }
}