package pl.falcor.ox.board;

import pl.falcor.ox.domain.Sign;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Field, Sign> gameBoard;
    private BoardDimension boardDimension;

    public Board(BoardDimension boardDimension) {
        this.boardDimension = boardDimension;
        this.gameBoard = new HashMap<>();
        for (int i = 1; i <= Math.pow(boardDimension.getDimension(), 2); i++)
            gameBoard.put(new Field(i), null);
    }

    public Map<Field, Sign> getGameBoard() {
        return gameBoard;
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