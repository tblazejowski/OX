package pl.falcor.ox.arbiter;

import pl.falcor.ox.board.Field;

import java.util.HashSet;
import java.util.Set;

public class Sequence {

    private Set<Field> sequence;

    public Sequence() {
        this.sequence = new HashSet<>();
    }

    public void addFieldToSequence(Field field){
        sequence.add(field);
    }
}