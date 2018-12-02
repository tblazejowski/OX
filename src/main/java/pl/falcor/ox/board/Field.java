package pl.falcor.ox.board;

import java.util.Objects;

/**
 * A {@code Field} object represents one field on board used for OX game
 * By convention field positioning/numbering starts in left top corner of a board
 * with 1 follows till the end of row incrementing number for each field by 1.
 * When row finishes field numbering continues from last row field number
 * with the same logic till the very last field in board.
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class Field {

    private int position;

    /**
     * @param position is a specific number of a field in board @see Field
     */
    public Field(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return position == field.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Field{" + position + '}';
    }
}