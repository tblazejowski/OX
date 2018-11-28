package pl.falcor.ox.domain;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Field, Sign> playingBoard;
    private BoardDimension boardDimension;

    public Board(Map<Field, Sign> playingBoard, BoardDimension boardDimension) {
        this.boardDimension = boardDimension;
        this.playingBoard = new HashMap<>();
        for (int i = 1; i <= boardDimension.getDimension(); i++)
            for (int j = 1; j <= boardDimension.getDimension(); j++) {
                playingBoard.put(new Field(i, j), null);
            }
    }
}