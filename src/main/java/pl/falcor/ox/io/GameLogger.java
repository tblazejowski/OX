package pl.falcor.ox.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameLogger {

    private static Logger logger = LogManager.getLogger(GameLogger.class);

    public void log(String msg) {
        logger.info(msg);
    }
}