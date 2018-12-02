package pl.falcor.ox.io;

/**
 * Interface used for reading input from game user
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public interface GameReader {

    int readNumber();

    String readLine();
}