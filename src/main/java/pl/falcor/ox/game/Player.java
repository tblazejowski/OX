package pl.falcor.ox.game;

import pl.falcor.ox.board.Sign;

/**
 * A {@code Player} object represents player for OX game
 * Player has name {@code String} and sign {@code Sign}
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class Player {

    private String name;
    private Sign sign;

    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public Sign getSign() {
        return sign;
    }
}