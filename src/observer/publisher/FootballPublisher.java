package observer.publisher;

import observer.subscriber.CricketSubscriber;
import observer.subscriber.FootballSubscriber;

public interface FootballPublisher {
    void subscribe(FootballSubscriber footballSubscriber);
    void unsubscribe(FootballSubscriber footballSubscriber);
    void notifyAll(int goals1, int goals2, double duration);
    int getGoals1();
    int getGoals2();
    double getDuration();
}
