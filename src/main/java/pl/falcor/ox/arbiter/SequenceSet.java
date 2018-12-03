package pl.falcor.ox.arbiter;

import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.Field;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


/**
 * A {@code SequenceSet} object represents sequence of fields {@code Field} in board {@code Board}
 *
 * @author Tomasz Błażejowski
 * @version 1.0, 30 Nov 2018
 */
class SequenceSet {

    private Set<Sequence> sequenceSet = new HashSet<>();
    private Board board;

    /**
     * constructor takes board {@code Board} as parameter to have
     * basis for sequnces {@code Sequence} construction
     *
     * @param board
     */
    SequenceSet(Board board) {
        this.board = board;
    }

    Set<Sequence> getSequenceSet() {
        return sequenceSet;
    }

    /**
     * Generates all potentially winning field {@code Field} sequences
     * for specific object ot type {@code Board}
     */
    void generateSequenceSet() {
        generateRowsSequenceSet();
        generateColumnsSequenceSet();
        generateMajorDiagonalSequenceSet();
        generateMinorDiagonalSequenceSet();
    }

    void generateRowsSequenceSet() {
        int dimension = board.getBoardDimension().getDimension();
        IntStream.iterate(1, i -> i + dimension).limit(dimension).forEach(i -> {
            Sequence sequence = new Sequence();
            IntStream.iterate(i, j -> j + 1).limit(dimension).forEach(k -> sequence.addFieldToSequence(new Field(k)));
            sequenceSet.add(sequence);
        });
    }

    void generateColumnsSequenceSet() {
        int dimension = board.getBoardDimension().getDimension();
        IntStream.iterate(1, i -> i + 1).limit(dimension).forEach(i -> {
            Sequence sequence = new Sequence();
            IntStream.iterate(i, j -> j + dimension).limit(dimension).forEach(k -> sequence.addFieldToSequence(new Field(k)));
            sequenceSet.add(sequence);
        });
    }

    void generateMajorDiagonalSequenceSet() {
        Sequence sequence = new Sequence();
        int dimension = board.getBoardDimension().getDimension();
        IntStream.iterate(1, i -> i + dimension + 1).limit(dimension)
                .forEach(j -> sequence.addFieldToSequence(new Field(j)));
        sequenceSet.add(sequence);
    }

    void generateMinorDiagonalSequenceSet() {
        Sequence sequence = new Sequence();
        int dimension = board.getBoardDimension().getDimension();
        IntStream.iterate(dimension, i -> i + (dimension - 1)).limit(dimension)
                .forEach(j -> sequence.addFieldToSequence(new Field(j)));
        sequenceSet.add(sequence);
    }

    @Override
    public String toString() {
        return "SequenceSet{" + sequenceSet + '}';
    }
}