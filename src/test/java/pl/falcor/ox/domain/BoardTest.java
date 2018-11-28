package pl.falcor.ox.domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class BoardTest {

    public void shouldReturnCorrectNumberOfFieldsInCreatedBoard()
    {
        Board board = new Board(new BoardDimension(6));

        assertEquals(board.getGameBoard().size(), 36);
    }
}