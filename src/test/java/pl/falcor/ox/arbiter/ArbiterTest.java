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

    private Board[] boards;
    private Arbiter[] arbiters;

    @BeforeTest
    public void initialize() {
        boards = new Board[7];
        arbiters = new Arbiter[7];
        for (int i = 0; i < boards.length; i++) {
            boards[i] = new Board(new BoardDimension(5));
            arbiters[i] = new Arbiter(boards[i]);
        }
    }


    @DataProvider(name = "testWinningSequenceOfXsInRow")
    public static Object[][] winningSequenceOfXsInRow() {
        return new Object[][]{
                {new Field(6), false},
                {new Field(7), false},
                {new Field(8), false},
                {new Field(9), false},
                {new Field(10), true},
        };
    }

    @Test(dataProvider = "testWinningSequenceOfXsInRow")
    public void shouldConfirmMatchWonWhenAllXSignsInTheSameRow(Field field, boolean result) {

        boards[0].addSign(field, Sign.X);

        Assert.assertEquals(arbiters[0].isWinningSign(field, Sign.X), result);
    }

    @DataProvider(name = "testWinningSequenceOfXsInColumn")
    public static Object[][] winningSequenceOfXsInColumn() {
        return new Object[][]{
                {new Field(4), false},
                {new Field(9), false},
                {new Field(14), false},
                {new Field(19), false},
                {new Field(24), true},
        };
    }

    @Test(dataProvider = "testWinningSequenceOfXsInColumn")
    public void shouldConfirmMatchWonWhenAllXSignsInTheSameColumn(Field field, boolean result) {

        boards[1].addSign(field, Sign.X);

        Assert.assertEquals(arbiters[1].isWinningSign(field, Sign.X), result);
    }

    @DataProvider(name = "testWinningSequenceOfXsInMajorDiagonal")
    public static Object[][] winningSequenceOfXsInMajorDiagonal() {
        return new Object[][]{
                {new Field(1), false},
                {new Field(7), false},
                {new Field(13), false},
                {new Field(19), false},
                {new Field(25), true},
        };
    }

    @Test(dataProvider = "testWinningSequenceOfXsInMajorDiagonal")
    public void shouldConfirmMatchWonWhenAllXSignsInTheMajorDiagonal(Field field, boolean result) {

        boards[2].addSign(field, Sign.X);

        Assert.assertEquals(arbiters[2].isWinningSign(field, Sign.X), result);
    }

    @DataProvider(name = "testWinningSequenceOfXsInMinorDiagonal")
    public static Object[][] winningSequenceOfXsInMinorDiagonal() {
        return new Object[][]{
                {new Field(5), false},
                {new Field(9), false},
                {new Field(13), false},
                {new Field(17), false},
                {new Field(21), true},
        };
    }

    @Test(dataProvider = "testWinningSequenceOfXsInMinorDiagonal")
    public void shouldConfirmMatchWonWhenAllXSignsInTheMinorDiagonal(Field field, boolean result) {

        boards[3].addSign(field, Sign.X);

        Assert.assertEquals(arbiters[3].isWinningSign(field, Sign.X), result);
    }

    @DataProvider(name = "testBoardIsFulfilledAndNoWinningConditionIsMet")
    public static Object[][] boardIsFulfilledAndNoWinningConditionIsMet() {
        return new Object[][]{
                {new Field(1), Sign.O},
                {new Field(2), Sign.X},
                {new Field(3), Sign.O},
                {new Field(4), Sign.X},
                {new Field(5), Sign.O},
                {new Field(6), Sign.O},
                {new Field(7), Sign.X},
                {new Field(8), Sign.O},
                {new Field(9), Sign.X},
                {new Field(10), Sign.O},
                {new Field(11), Sign.O},
                {new Field(12), Sign.X},
                {new Field(13), Sign.O},
                {new Field(14), Sign.X},
                {new Field(15), Sign.O},
                {new Field(16), Sign.O},
                {new Field(17), Sign.X},
                {new Field(18), Sign.O},
                {new Field(19), Sign.X},
                {new Field(20), Sign.O},
                {new Field(21), Sign.X},
                {new Field(22), Sign.O},
                {new Field(23), Sign.X},
                {new Field(24), Sign.O},
                {new Field(25), Sign.X},
        };
    }

    @Test(dataProvider = "testBoardIsFulfilledAndNoWinningConditionIsMet")
    public void shouldConfirmBoardIsFulfilledAndNoWinningConditionIsMet(Field field, Sign sign) {

        boards[4].addSign(field, sign);

        if (field.getPosition() < 25)
            Assert.assertFalse(arbiters[4].isWinningSign(field, sign) || arbiters[4].isDrawn(field, sign));
        else {
            Assert.assertFalse(arbiters[4].isWinningSign(field, sign));
            Assert.assertTrue(arbiters[4].isDrawn(field, sign));
        }
    }

    @DataProvider(name = "testWinningConditionIsMetInLastFulfillingBoardMove")
    public static Object[][] winningConditionIsMetInLastFulfillingBoardMove() {
        return new Object[][]{
                {new Field(1), Sign.O},
                {new Field(2), Sign.X},
                {new Field(3), Sign.O},
                {new Field(4), Sign.X},
                {new Field(5), Sign.O},
                {new Field(6), Sign.O},
                {new Field(7), Sign.X},
                {new Field(8), Sign.O},
                {new Field(9), Sign.X},
                {new Field(10), Sign.O},
                {new Field(11), Sign.O},
                {new Field(12), Sign.X},
                {new Field(13), Sign.O},
                {new Field(14), Sign.X},
                {new Field(15), Sign.O},
                {new Field(16), Sign.O},
                {new Field(17), Sign.X},
                {new Field(18), Sign.O},
                {new Field(19), Sign.X},
                {new Field(20), Sign.O},
                {new Field(21), Sign.X},
                {new Field(22), Sign.O},
                {new Field(23), Sign.X},
                {new Field(24), Sign.O},
                {new Field(25), Sign.O},
        };
    }

    @Test(dataProvider = "testWinningConditionIsMetInLastFulfillingBoardMove")
    public void shouldConfirmWinningConditionIsMetInLastFulfillingBoardMove(Field field, Sign sign) {

        boards[5].addSign(field, sign);

        if (field.getPosition() == 25) Assert.assertTrue(arbiters[5].isWinningSign(field, sign));
        else Assert.assertFalse(arbiters[5].isWinningSign(field, sign));
    }
}