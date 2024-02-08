package logger.subscriber;

public class ConsoleSubscriber implements Subscriber {
    @Override
    public void update(String message) {
        System.out.println(message);
    }

}
