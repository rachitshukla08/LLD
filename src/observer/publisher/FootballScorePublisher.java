package observer.publisher;

import observer.subscriber.CricketSubscriber;
import observer.subscriber.FootballSubscriber;

public class FootballScorePublisher implements FootballPublisher{
    @Override
    public void subscribe(FootballSubscriber footballSubscriber) {

    }

    @Override
    public void unsubscribe(FootballSubscriber footballSubscriber) {

    }

    @Override
    public void notifyAll(int goals1, int goals2, double duration) {

    }

    @Override
    public int getGoals1() {
        return 0;
    }

    @Override
    public int getGoals2() {
        return 0;
    }

    @Override
    public double getDuration() {
        return 0;
    }
}
