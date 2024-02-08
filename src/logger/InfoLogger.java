package logger;

import logger.data.LogLevel;
import logger.publisher.Publisher;

import java.io.IOException;

public class InfoLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public InfoLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) throws IOException {
        if(logLevel.getLevel() == LogLevel.INFO.getLevel()){
            logPublisher.notify(LogLevel.INFO + " : "+ message);
        }
        nextLogger.log(logLevel, message);
    }
}
