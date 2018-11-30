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

    public Arbiter(Board gameBoard) {
        this.gameBoard = gameBoard;
        this.sequenceSet = new SequenceSet(gameBoard);
        sequenceSet.generateSequenceSet();
        this.setX = new HashSet<>();
        this.setO = new HashSet<>();
    }

    boolean isWinningSign(Field field, Sign sign) {

        assignFreeSequenceToSpecificSign(field, sign);
        cleanUsedSequencesFromFreePool(field, sign);
        trashSequencesUsedByBothSignPools(field, sign);
        removeUsedFieldFromPotentialSequence(field, sign);
        return searchForEmptySequence();
    }

    boolean isDrawn(Field field, Sign sign){
        if(setX.isEmpty() && setO.isEmpty()) return true;
        else return false;
    }

    private boolean searchForEmptySequence() {
        return setX.stream().anyMatch(sequence -> sequence.getSequence().size() == 0) || setO.stream().anyMatch(sequence -> sequence.getSequence().size() == 0);
    }

    private void removeUsedFieldFromPotentialSequence(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            setX.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> sequence.getSequence().remove(field));
        else
            setO.stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> sequence.getSequence().remove(field));
    }

    private void trashSequencesUsedByBothSignPools(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            setO.removeIf(sequence -> sequence.getSequence().contains(field));
        else
            setX.removeIf(sequence -> sequence.getSequence().contains(field));
    }

    private void cleanUsedSequencesFromFreePool(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            sequenceSet.getSequenceSet().removeAll(setX);
        else
            sequenceSet.getSequenceSet().removeAll(setO);
    }

    private void assignFreeSequenceToSpecificSign(Field field, Sign sign) {
        if (sign.equals(Sign.X))
            sequenceSet.getSequenceSet().stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> setX.add(sequence));
        else
            sequenceSet.getSequenceSet().stream().filter(sequence -> sequence.getSequence().contains(field)).forEach(sequence -> setO.add(sequence));
    }
}