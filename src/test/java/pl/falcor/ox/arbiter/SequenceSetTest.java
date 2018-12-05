package pl.falcor.ox.arbiter;

import org.testng.annotations.Test;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.board.Field;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class SequenceSetTest {

    public void ShouldReturnCorrectNumberOfRowSequencesForSpecificBoard() {
        Board board = new Board(new BoardDimension(7));
        SequenceSet sequenceSet = new SequenceSet(board);

        sequenceSet.generateRowsSequenceSet();

        assertEquals(sequenceSet.getSequenceSet().size(), 7);
    }

    public void ShouldConfirmRowSequencesSetForSpecificBoardContainExpectedSequence() {
        Board board = new Board(new BoardDimension(5));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        sequence1.addFieldToSequence(new Field(6));
        sequence1.addFieldToSequence(new Field(7));
        sequence1.addFieldToSequence(new Field(8));
        sequence1.addFieldToSequence(new Field(9));
        sequence1.addFieldToSequence(new Field(10));

        sequenceSet.generateRowsSequenceSet();

        assertTrue(sequenceSet.getSequenceSet().contains(sequence1));
    }

    public void ShouldReturnCorrectNumberOfColumnSequencesForSpecificBoard() {
        Board board = new Board(new BoardDimension(7));
        SequenceSet sequenceSet = new SequenceSet(board);

        sequenceSet.generateColumnsSequenceSet();

        assertEquals(sequenceSet.getSequenceSet().size(), 7);
    }

    public void ShouldConfirmColumnSequencesSetForSpecificBoardContainsExpectedSequence() {
        Board board = new Board(new BoardDimension(5));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        sequence1.addFieldToSequence(new Field(3));
        sequence1.addFieldToSequence(new Field(8));
        sequence1.addFieldToSequence(new Field(13));
        sequence1.addFieldToSequence(new Field(18));
        sequence1.addFieldToSequence(new Field(23));

        sequenceSet.generateColumnsSequenceSet();

        assertTrue(sequenceSet.getSequenceSet().contains(sequence1));
    }

    public void ShouldConfirmMajorDiagonalSequencesSetForSpecificBoardContainsExpectedSequence() {
        Board board = new Board(new BoardDimension(5));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        sequence1.addFieldToSequence(new Field(1));
        sequence1.addFieldToSequence(new Field(7));
        sequence1.addFieldToSequence(new Field(13));
        sequence1.addFieldToSequence(new Field(19));
        sequence1.addFieldToSequence(new Field(25));

        sequenceSet.generateMajorDiagonalSequenceSet();

        assertTrue(sequenceSet.getSequenceSet().contains(sequence1));
    }

    public void ShouldConfirmMinorDiagonalSequencesSetForSpecificBoardContainsExpectedSequence() {
        Board board = new Board(new BoardDimension(5));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        sequence1.addFieldToSequence(new Field(5));
        sequence1.addFieldToSequence(new Field(9));
        sequence1.addFieldToSequence(new Field(13));
        sequence1.addFieldToSequence(new Field(17));
        sequence1.addFieldToSequence(new Field(21));

        sequenceSet.generateMinorDiagonalSequenceSet();

        assertTrue(sequenceSet.getSequenceSet().contains(sequence1));
    }

    public void ShouldConfirmSequencesSetForSpecificBoardContainsAllExpectedSequences() {
        Board board = new Board(new BoardDimension(3));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        Sequence sequence2 = new Sequence();
        Sequence sequence3 = new Sequence();
        Sequence sequence4 = new Sequence();
        Sequence sequence5 = new Sequence();
        Sequence sequence6 = new Sequence();
        Sequence sequence7 = new Sequence();
        Sequence sequence8 = new Sequence();
        sequence1.addFieldToSequence(new Field(1));
        sequence1.addFieldToSequence(new Field(2));
        sequence1.addFieldToSequence(new Field(3));
        sequence2.addFieldToSequence(new Field(4));
        sequence2.addFieldToSequence(new Field(5));
        sequence2.addFieldToSequence(new Field(6));
        sequence3.addFieldToSequence(new Field(7));
        sequence3.addFieldToSequence(new Field(8));
        sequence3.addFieldToSequence(new Field(9));
        sequence4.addFieldToSequence(new Field(1));
        sequence4.addFieldToSequence(new Field(4));
        sequence4.addFieldToSequence(new Field(7));
        sequence5.addFieldToSequence(new Field(2));
        sequence5.addFieldToSequence(new Field(5));
        sequence5.addFieldToSequence(new Field(8));
        sequence6.addFieldToSequence(new Field(3));
        sequence6.addFieldToSequence(new Field(6));
        sequence6.addFieldToSequence(new Field(9));
        sequence7.addFieldToSequence(new Field(1));
        sequence7.addFieldToSequence(new Field(5));
        sequence7.addFieldToSequence(new Field(9));
        sequence8.addFieldToSequence(new Field(3));
        sequence8.addFieldToSequence(new Field(5));
        sequence8.addFieldToSequence(new Field(7));

        sequenceSet.generateSequenceSet();

        assertTrue(sequenceSet.getSequenceSet().contains(sequence1));
        assertTrue(sequenceSet.getSequenceSet().contains(sequence2));
        assertTrue(sequenceSet.getSequenceSet().contains(sequence3));
        assertTrue(sequenceSet.getSequenceSet().contains(sequence4));
        assertTrue(sequenceSet.getSequenceSet().contains(sequence5));
        assertTrue(sequenceSet.getSequenceSet().contains(sequence6));
        assertTrue(sequenceSet.getSequenceSet().contains(sequence7));
        assertTrue(sequenceSet.getSequenceSet().contains(sequence8));
        assertEquals(sequenceSet.getSequenceSet().size(), 8);
    }
}