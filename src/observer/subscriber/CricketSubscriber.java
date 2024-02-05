package observer.subscriber;

import observer.publisher.CricketPublisher;

public interface CricketSubscriber {
    public void update(CricketPublisher cricketPublisher);
    public void addPublisher(CricketPublisher cricketPublisher);
}
