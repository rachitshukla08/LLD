package logger.publisher;

import logger.subscriber.Subscriber;

import java.io.IOException;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notify(String message) throws IOException;
}
