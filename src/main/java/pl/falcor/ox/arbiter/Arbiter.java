package pl.falcor.ox.arbiter;

import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.Field;
import pl.falcor.ox.board.Sign;

import java.util.HashSet;
import java.util.Set;

public class Arbiter {

    private Board gameBoard;
    private SequenceSet sequenceSet;
    private Set<Sequence> setX;
    private Set<Sequence> setO;
    private Set<Sequence> trashSet;

    public Set<Sequence> getSetX() {
        return setX;
    }

    public Set<Sequence> getSetO() {
        return setO;
    }

    public Set<Sequence> getTrashSet() {
        return trashSet;
    }

    public SequenceSet getSequenceSet() {
        return sequenceSet;
    }

    public Arbiter(Board gameBoard) {
        this.gameBoard = gameBoard;
        this.sequenceSet = new SequenceSet(gameBoard);
        sequenceSet.generateSequenceSet();
        this.setX = new HashSet<>();
        this.setO = new HashSet<>();
        this.trashSet = new HashSet<>();
    }

    boolean isWinningSign(Field field, Sign sign) {

        assignFreeSequenceToSpecificSign(field, sign);
        removeUsedSequenceFromFreePool(field, sign);
        removeUsedSequenceFromOppositeSet(field, sign);
        removeTrashedSequences(field, sign);
        return false;
    }

    private void removeTrashedSequences(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            trashSet.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> setO.remove(sequence));
        else
            trashSet.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> setX.remove(sequence));
        trashSet.clear();
    }

    private void removeUsedSequenceFromOppositeSet(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            setO.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> trashSet.add(sequence));
        else
            setX.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> trashSet.add(sequence));
    }

    private void removeUsedSequenceFromFreePool(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            setX.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> sequenceSet.getSequenceSet().remove(sequence));
        else
            setO.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> sequenceSet.getSequenceSet().remove(sequence));
    }

    private void assignFreeSequenceToSpecificSign(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            sequenceSet.getSequenceSet().stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> setX.add(sequence));
        else
            sequenceSet.getSequenceSet().stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> setO.add(sequence));
    }
}