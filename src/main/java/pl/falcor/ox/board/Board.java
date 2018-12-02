package pl.falcor.ox.board;

import java.util.HashMap;
import java.util.Map;

/**
 * A {@code Board} object represents board used for OX game
 * Board has fields {@code Fields} that are mapped as keys and
 * indicate values - signs {@code Sign}.
 * Board has also its dimension {@code BoardDimension}
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class Board {

    private Map<Field, Sign> gameBoard;
    private BoardDimension boardDimension;

    /**
     * constructor creates map where key is {@code Field} and values is {@code Sign}
     * with fields number according to BoardDimension
     *
     * @param boardDimension BoardDimension indicates the size of board should have.
     */
    public Board(BoardDimension boardDimension) {
        this.boardDimension = boardDimension;
        this.gameBoard = new HashMap<>();
        for (int i = 1; i <= Math.pow(boardDimension.getDimension(), 2); i++)
            gameBoard.put(new Field(i), null);
    }

    public Map<Field, Sign> getGameBoard() {
        return gameBoard;
    }

    public BoardDimension getBoardDimension() {
        return boardDimension;
    }

    public void addSign(Field field, Sign sign){
        gameBoard.put(field, sign);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= Math.pow(boardDimension.getDimension(), 2); i++) {
            if (i / 10 < 1) {
                if (gameBoard.get(new Field(i)) == null) result.append("  " + i);
                else result.append("  " + gameBoard.get(new Field(i)));
            } else {
                if (gameBoard.get(new Field(i)) == null) result.append(" " + i);
                else result.append("  " + gameBoard.get(new Field(i)));
            }
            if (i % boardDimension.getDimension() == 0) result.append("\n");
        }
        return result.toString();
    }
}