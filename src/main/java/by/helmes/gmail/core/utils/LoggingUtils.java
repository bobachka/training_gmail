package by.helmes.gmail.core.utils;

import org.apache.log4j.Logger;

public class LoggingUtils {
    private static final Logger LOGGER = Logger.getLogger("test logger");

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logErr(String message) {
        LOGGER.error(message);
    }
}
