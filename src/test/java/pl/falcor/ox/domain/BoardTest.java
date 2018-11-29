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

    public void shouldPrintCorrectlyEmptyBoard()
    {
        Board board = new Board(new BoardDimension(6));

        assertEquals(board.toString(), "  1  2  3  4  5  6\n" +
                "  7  8  9 10 11 12\n" +
                " 13 14 15 16 17 18\n" +
                " 19 20 21 22 23 24\n" +
                " 25 26 27 28 29 30\n" +
                " 31 32 33 34 35 36\n");
    }
}