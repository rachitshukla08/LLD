package logger;

import logger.data.LogLevel;

import java.io.IOException;

public interface Logger {
    void log(LogLevel logLevel, String message) throws IOException;
}
