package logger;

import logger.data.LogLevel;
import logger.publisher.Publisher;

import java.io.IOException;

public class ErrorLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public ErrorLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) throws IOException {
        if(logLevel.getLevel() == LogLevel.ERROR.getLevel()){
            logPublisher.notify(LogLevel.ERROR + " : " + message);
        }
        nextLogger.log(logLevel, message);
    }
}
