package logger;

import logger.data.LogLevel;
import logger.publisher.Publisher;

import java.io.IOException;

public class DebugLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public DebugLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) throws IOException {
        if(logLevel.getLevel() == LogLevel.DEBUG.getLevel()){
            this.logPublisher.notify(LogLevel.DEBUG + " : "+ message);
        }
        nextLogger.log(logLevel, message);
    }
}
