package pl.falcor.ox.arbiter;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.board.Field;
import pl.falcor.ox.board.Sign;

public class ArbiterTest {

    private Board board;
    private Arbiter arbiter;

    @BeforeTest
    public void initialize() {
        board = new Board(new BoardDimension(4));
        arbiter = new Arbiter(board);
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

        board.addSign(field, Sign.X);

        Assert.assertEquals(arbiter.isWinningSign(field, Sign.X), result);
    }
}