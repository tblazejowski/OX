package pl.falcor.ox.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Responsible for logging messages while app runs.
 *
 * @author Tomasz Błażejowski
 * @version 2.0, 30 Nov 2018
 */
public class GameLogger {

    private static Logger logger = LogManager.getLogger("");

    public void log(String msg) {
        logger.info(msg);
    }
}