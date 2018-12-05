package pl.falcor.ox.arbiter;

import pl.falcor.ox.board.Board;
import pl.falcor.ox.board.Field;
import pl.falcor.ox.board.Sign;

import java.util.HashSet;
import java.util.Set;

/**
 * A {@code Arbiter} object represents arbiter
 * whose role is decide if conditions ending match are met
 * after sign is added to specific field.
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class Arbiter {

    private final SequenceSet sequenceSet;
    private final Set<Sequence> setX;
    private final Set<Sequence> setO;

    /**
     * @param gameBoard
     *
     * constructor with one parameter creates object of type {@code Arbiter}
     * binding it with object of type {@code Board} on which game takes place
     */
    public Arbiter(Board gameBoard) {
        this.sequenceSet = new SequenceSet(gameBoard);
        sequenceSet.generateSequenceSet();
        this.setX = new HashSet<>();
        this.setO = new HashSet<>();
    }

    /**
     * Checks if sign put on specific field finishes the game
     * both when one wins the match or match is drawn
     *
     * @param field Field on which sign was put
     * @param sign Sign that was put on this field
     * @return true if sign put on this field finishes the game
     */
    public boolean isEndingMatchSign(Field field, Sign sign) {

        assignFreeSequenceToSpecificSign(field, sign);
        cleanUsedSequencesFromFreePool(field, sign);
        trashSequencesUsedByBothSignPools(field, sign);
        removeUsedFieldFromPotentiallyWinningSequence(field, sign);
        return searchForEmptySequence() || isDrawn();
    }

    boolean isDrawn() {
        return setX.isEmpty() && setO.isEmpty() && sequenceSet.getSequenceSet().isEmpty();
    }

    /**
     * Indicates which Sign won the match
     *
     * @return Sign that won the match or
     * null if no winner and match was drawn
     */
    public Sign indicateWhoWon() {
        if (isDrawn()) return null;
        else if (setX.stream().anyMatch(sequence -> sequence.getSequence().size() == 0)) return Sign.X;
        else return Sign.O;
    }

    private boolean searchForEmptySequence() {
        return setX.stream().anyMatch(sequence -> sequence.getSequence().size() == 0) || setO.stream().anyMatch(sequence -> sequence.getSequence().size() == 0);
    }

    private void removeUsedFieldFromPotentiallyWinningSequence(Field field, Sign sign) {
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