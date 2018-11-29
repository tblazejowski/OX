package pl.falcor.ox.arbiter;

import pl.falcor.ox.board.Field;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sequence {

    private Set<Field> sequence;

    public Sequence() {
        this.sequence = new HashSet<>();
    }

    public void addFieldToSequence(Field field) {
        sequence.add(field);
    }

    @Override
    public String toString() {
        return "Sequence{" + sequence + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sequence sequence1 = (Sequence) o;
        return Objects.equals(sequence, sequence1.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence);
    }
}