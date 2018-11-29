package pl.falcor.ox.arbiter;

import org.testng.annotations.Test;
import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.BoardDimension;

import static org.testng.Assert.*;

@Test
public class SequenceSetTest {

    public void ShouldReturnCorrectNumberOfRowSequencesForSpecificBoard()
    {
        Board board = new Board(new BoardDimension(7));
        SequenceSet sequenceSet = new SequenceSet(board);

        sequenceSet.generateRowsSequenceSets();

        assertEquals(sequenceSet.getSequenceSet().size(), 7);
    }
}