package logger;

import logger.data.LogLevel;
import logger.publisher.Publisher;

import java.io.IOException;

public class FatalLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public FatalLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) throws IOException {
        if(logLevel.getLevel() == LogLevel.FATAL.getLevel()){
            logPublisher.notify(LogLevel.FATAL + " : "+ message);
        }
        nextLogger.log(logLevel, message);
    }
}
