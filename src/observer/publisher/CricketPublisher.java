package observer.publisher;

import observer.subscriber.CricketSubscriber;

public interface CricketPublisher {
    void subscribe(CricketSubscriber cricketSubscriber);
    void unsubscribe(CricketSubscriber cricketSubscriber);
    void notifyAll(int runs, int wickets, double overs);
    int getRuns();
    int getWickets();
    double getOvers();
}
