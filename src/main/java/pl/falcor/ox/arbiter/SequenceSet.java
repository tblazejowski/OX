package pl.falcor.ox.arbiter;

import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.Field;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SequenceSet {

    private Set<Sequence> sequenceSet = new HashSet<>();
    private Board board;

    public SequenceSet(Board board) {
        this.board = board;
    }

    public Set<Sequence> getSequenceSet() {
        return sequenceSet;
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

    @Override
    public String toString() {
        return "SequenceSet{" + sequenceSet + '}';
    }
}