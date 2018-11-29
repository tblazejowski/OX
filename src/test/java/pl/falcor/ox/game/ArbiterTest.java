package pl.falcor.ox.game;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.board.Field;
import pl.falcor.ox.board.Sign;

public class ArbiterTest {

    private Board[] arrayOfBoards;
    private Arbiter arbiter;

    @BeforeTest
    public void initialize() {
        arbiter = new Arbiter();
        arrayOfBoards = new Board[1];
        for (int i = 0; i < arrayOfBoards.length; i++) {
            arrayOfBoards[i] = new Board(new BoardDimension(4));
        }
    }

    @DataProvider(name = "testWinningSequenceOfXsInRow")
    public static Object[][] winningSequenceOfXsInRow() {
        return new Object[][]{
                {new Field(5), false},
                {new Field(6), false},
                {new Field(7), false},
                {new Field(8), true},
        };
    }

    @Test(dataProvider = "testWinningSequenceOfXsInRow")
    public void shouldConfirmMatchWonWhenAllXSignsInTheSameRow(Field field, boolean result) {

        arrayOfBoards[0].addSign(field, Sign.X);
        System.out.println(arrayOfBoards[0].toString());

        Assert.assertEquals(arbiter.isWon(arrayOfBoards[0]), result);
    }
}