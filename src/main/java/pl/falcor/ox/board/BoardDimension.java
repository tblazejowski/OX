package pl.falcor.ox.board;

/**
 * A {@code BoardDimmension} object represents lateral dimension of board used for OX game
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class BoardDimension {

    private final int dimension;

    /**
     * @param boardDimension side length of board
     */
    public BoardDimension(int boardDimension) {
        this.dimension = boardDimension;
    }

    public int getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "BoardDimension{" +
                "dimension=" + dimension +
                '}';
    }
}