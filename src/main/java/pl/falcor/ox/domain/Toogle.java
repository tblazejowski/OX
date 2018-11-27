package pl.falcor.ox.domain;

public interface Toogle {

    default void swapObjectsInArray(Object[] objects) {
        Object temporary = objects[0];
        objects[0] = objects[1];
        objects[1] = temporary;
    }

}