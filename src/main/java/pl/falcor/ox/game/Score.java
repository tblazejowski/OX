package pl.falcor.ox.game;

public class Score {

    private int[] score;

    public Score(int numberOfPlayers) {
        this.score = new int[numberOfPlayers];
        for (int i = 0; i < score.length; i++) {
            score[i] = 0;
        }
    }

    public int[] getScore() {
        return score;
    }
}
