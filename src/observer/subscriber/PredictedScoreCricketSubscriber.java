package observer.subscriber;

import observer.publisher.CricketPublisher;
import observer.publisher.FootballPublisher;

import java.util.List;

public class PredictedScoreCricketSubscriber implements CricketSubscriber, FootballSubscriber {
    private int runs;
    private int wickets;
    private double overs;
    private int goals1;
    private int goals2;
    private double duration;
    private final List<CricketPublisher> cricketPublishers;

    public PredictedScoreCricketSubscriber(List<CricketPublisher> cricketPublishers) {
        this.cricketPublishers = cricketPublishers;
        for(CricketPublisher cricketPublisher : cricketPublishers) {
            cricketPublisher.subscribe(this);
        }
    }

    @Override
    public void update(CricketPublisher cricketPublisher) {
        this.runs = cricketPublisher.getRuns();
        this.wickets = cricketPublisher.getWickets();
        this.overs = cricketPublisher.getOvers();
        System.out.println("Updated pred score "+this.runs+" "+ this.wickets +" "+this.overs);
    }

    @Override
    public void addPublisher(CricketPublisher cricketPublisher) {
        this.cricketPublishers.add(cricketPublisher);
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public double getOvers() {
        return overs;
    }

    public List<CricketPublisher> getPublisher() {
        return cricketPublishers;
    }

    @Override
    public void update(FootballPublisher footballPublisher) {
        this.goals1 = footballPublisher.getGoals1();
        this.goals2 = footballPublisher.getGoals2();
        this.duration = footballPublisher.getDuration();
        System.out.println("Updated football score");
    }
}
