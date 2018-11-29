package pl.falcor.ox.arbiter;

import org.testng.annotations.Test;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.board.Field;

import static org.testng.Assert.assertEquals;

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

        assertEquals(sequenceSet.getSequenceSet().contains(sequence1), true);
    }

    public void ShouldReturnCorrectNumberOfColumnSequencesForSpecificBoard() {
        Board board = new Board(new BoardDimension(7));
        SequenceSet sequenceSet = new SequenceSet(board);

        sequenceSet.generateColumnsSequenceSet();

        assertEquals(sequenceSet.getSequenceSet().size(), 7);
    }

    public void ShouldConfirmColumnSequencesSetForSpecificBoardContainExpectedSequence() {
        Board board = new Board(new BoardDimension(5));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        sequence1.addFieldToSequence(new Field(3));
        sequence1.addFieldToSequence(new Field(8));
        sequence1.addFieldToSequence(new Field(13));
        sequence1.addFieldToSequence(new Field(18));
        sequence1.addFieldToSequence(new Field(23));

        sequenceSet.generateColumnsSequenceSet();

        assertEquals(sequenceSet.getSequenceSet().contains(sequence1), true);
    }

    public void ShouldConfirmMajorDiagonalSequencesSetForSpecificBoardContainExpectedSequence() {
        Board board = new Board(new BoardDimension(5));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        sequence1.addFieldToSequence(new Field(1));
        sequence1.addFieldToSequence(new Field(7));
        sequence1.addFieldToSequence(new Field(13));
        sequence1.addFieldToSequence(new Field(19));
        sequence1.addFieldToSequence(new Field(25));

        sequenceSet.generateMajorDiagonalSequenceSet();

        assertEquals(sequenceSet.getSequenceSet().contains(sequence1), true);
    }

    public void ShouldConfirmMinorDiagonalSequencesSetForSpecificBoardContainExpectedSequence() {
        Board board = new Board(new BoardDimension(5));
        SequenceSet sequenceSet = new SequenceSet(board);
        Sequence sequence1 = new Sequence();
        sequence1.addFieldToSequence(new Field(5));
        sequence1.addFieldToSequence(new Field(9));
        sequence1.addFieldToSequence(new Field(13));
        sequence1.addFieldToSequence(new Field(17));
        sequence1.addFieldToSequence(new Field(21));

        sequenceSet.generateMinorDiagonalSequenceSet();
        System.out.println(sequence1);
        System.out.println(sequenceSet);

        assertEquals(sequenceSet.getSequenceSet().contains(sequence1), true);
    }
}