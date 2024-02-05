package observer.publisher;

import observer.subscriber.CricketSubscriber;

import java.util.ArrayList;
import java.util.List;

public class SonyCricketScoreBoarCricketPublisher implements CricketPublisher {
    private int runs;
    private int wickets;
    private double overs;
    List<CricketSubscriber> cricketSubscribers;

    public SonyCricketScoreBoarCricketPublisher(){
        this.cricketSubscribers = new ArrayList<>();
    }

    public void subscribe(CricketSubscriber cricketSubscriber){
        cricketSubscribers.add(cricketSubscriber);
    }

    public void unsubscribe(CricketSubscriber cricketSubscriber){
        cricketSubscribers.remove(cricketSubscriber);
    }

    public void notifyAll(int runs, int wickets, double overs){
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        for(CricketSubscriber cricketSubscriber : cricketSubscribers){
            cricketSubscriber.update(this);
        }
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }
}
