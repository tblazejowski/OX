package pl.falcor.ox.domain;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Field, Sign> gameBoard;
    private BoardDimension boardDimension;

    public Board(BoardDimension boardDimension) {
        this.boardDimension = boardDimension;
        this.gameBoard = new HashMap<>();
        for (int i = 1; i <= boardDimension.getDimension(); i++)
            for (int j = 1; j <= boardDimension.getDimension(); j++) {
                gameBoard.put(new Field(i, j), null);
            }
    }

    public Map<Field, Sign> getGameBoard() {
        return gameBoard;
    }

//    @Override
//    public String toString() {
//
//        StringBuilder result = new StringBuilder();
//        for (Map.Entry<Field, Sign> fieldSignEntry : gameBoard.entrySet()){
//            result.append(fieldSignEntry.getKey().getRow() + fieldSignEntry.getKey().getColumn() + " ");
//        }
//        return result.toString();
//    }
}