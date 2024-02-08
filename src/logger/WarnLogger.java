package logger;

import logger.data.LogLevel;
import logger.publisher.Publisher;

import java.io.IOException;

public class WarnLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public WarnLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) throws IOException {
        if(logLevel.getLevel() == LogLevel.WARN.getLevel()){
            logPublisher.notify(LogLevel.WARN + " : "+ message);
        }
        nextLogger.log(logLevel, message);
    }
}
