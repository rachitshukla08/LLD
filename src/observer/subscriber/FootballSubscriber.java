package observer.subscriber;

import observer.publisher.FootballPublisher;

public interface FootballSubscriber {
    void update(FootballPublisher footballPublisher);
}
