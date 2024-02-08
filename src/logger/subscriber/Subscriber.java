package logger.subscriber;

import java.io.IOException;

public interface Subscriber {
    void update(String message) throws IOException;
}
