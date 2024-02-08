package logger;

import logger.data.LogLevel;

public class IdleLogger implements Logger{
    @Override
    public void log(LogLevel logLevel, String message) {
        System.out.println("Completed logging");
    }
}
