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

    private Board[] arrayOfBoards;
    private Arbiter arbiter;

    @BeforeTest
    public void initialize() {
        arrayOfBoards = new Board[2];
        for (int i = 0; i < arrayOfBoards.length; i++) {
            arrayOfBoards[i] = new Board(new BoardDimension(4));
        }
    }

    @Test
    public void XTest(){
        Board board = new Board(new BoardDimension(3));
        arbiter = new Arbiter(board);
        Field field5 = new Field(5);
        Field field3 = new Field(3);
        board.addSign(field5, Sign.X);
        arbiter.isWinningSign(field5, Sign.X);
        board.addSign(field3, Sign.O);
        arbiter.isWinningSign(field3, Sign.O);
        System.out.println(board.toString());
        System.out.println(arbiter.getSetX().toString());
        System.out.println(arbiter.getSetO().toString());
        System.out.println(arbiter.getTrashSet().toString());
        System.out.println(arbiter.getSetX().size());
        System.out.println(arbiter.getSetO().size());

        System.out.println(arbiter.getSequenceSet().getSequenceSet().size());

        Assert.assertFalse(arbiter.isWinningSign(field5, Sign.X));

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

        arbiter = new Arbiter(arrayOfBoards[1]);
        arrayOfBoards[0].addSign(field, Sign.X);
        System.out.println(arrayOfBoards[1].toString());

        Assert.assertEquals(arbiter.isWinningSign(field, Sign.X), result);
    }
}