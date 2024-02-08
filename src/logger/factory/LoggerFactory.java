package logger.factory;


import logger.*;
import logger.publisher.LogPublisher;
import logger.publisher.Publisher;
import logger.subscriber.ConsoleSubscriber;
import logger.subscriber.FileSubscriber;

import java.io.IOException;

public class LoggerFactory {
    private LoggerFactory(){
    }

    public static Logger getLogger() {
        Publisher debugInfoPub = new LogPublisher();
        debugInfoPub.subscribe(new ConsoleSubscriber());
        Publisher warnAndAbove = new LogPublisher();
        warnAndAbove.subscribe(new ConsoleSubscriber());
        try {
            warnAndAbove.subscribe(new FileSubscriber("log.txt"));
        }
        catch (Exception e){
            throw new RuntimeException("Error in file read");
        }
        return new DebugLogger(
                new InfoLogger(
                        new WarnLogger(
                                new ErrorLogger(
                                        new FatalLogger(
                                                new IdleLogger(),
                                                warnAndAbove
                                        ),
                                        warnAndAbove
                                        ),
                                warnAndAbove
                        ),
                        debugInfoPub
                ),
                debugInfoPub
        );
    }

}
