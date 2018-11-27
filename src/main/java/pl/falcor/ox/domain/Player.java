package pl.falcor.ox.domain;

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
