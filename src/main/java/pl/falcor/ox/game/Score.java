package pl.falcor.ox.game;

/**
 * A {@code Score} object represents score for OX game
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
class Score {

    private final int[] score;

    Score(int numberOfPlayers) {
        this.score = new int[numberOfPlayers];
        for (int i = 0; i < score.length; i++) {
            score[i] = 0;
        }
    }

    int[] getScore() {
        return score;
    }
}
