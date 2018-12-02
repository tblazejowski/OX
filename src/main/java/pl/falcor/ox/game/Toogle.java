package pl.falcor.ox.game;

/**
 * Interface that toggles order of first pair of elements in an array
 * Used for swapping turn during match in OX game @see Match
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public interface Toogle {

    default void swapObjectsInArray(Object[] objects) {
        Object temporary = objects[0];
        objects[0] = objects[1];
        objects[1] = temporary;
    }
}