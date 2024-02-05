package observer;

import observer.publisher.CricketScoreBoardCricketPublisher;
import observer.publisher.CricketPublisher;
import observer.publisher.FootballPublisher;
import observer.publisher.FootballScorePublisher;
import observer.subscriber.CricketSubscriber;
import observer.subscriber.FootballSubscriber;
import observer.subscriber.PredictedScoreCricketSubscriber;

import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        CricketScoreBoardCricketPublisher cricketScoreBoardPublisher= new CricketScoreBoardCricketPublisher();
        PredictedScoreCricketSubscriber predictedScoreSubscriber = new PredictedScoreCricketSubscriber(Arrays.asList(cricketScoreBoardPublisher));
        FootballPublisher footballPublisher = new FootballScorePublisher();
        connect(cricketScoreBoardPublisher, Arrays.asList(predictedScoreSubscriber));
        connect(footballPublisher, Arrays.asList(predictedScoreSubscriber));
        cricketScoreBoardPublisher.notifyAll(50,2,5.3);
//        predictedScoreSubscriber.getPublisher().unsubscribe(predictedScoreSubscriber);
        cricketScoreBoardPublisher.notifyAll(100,3,10.3);
    }

    public static void connect(CricketPublisher cricketPublisher, List<CricketSubscriber> cricketSubscribers){
        for(CricketSubscriber cricketSubscriber : cricketSubscribers){
            cricketPublisher.subscribe(cricketSubscriber);
        }
    }

    public static void connect(FootballPublisher footballPublisher, List<FootballSubscriber> footballSubscribers){
        for(FootballSubscriber footballSubscriber : footballSubscribers){
            footballPublisher.subscribe(footballSubscriber);
        }
    }
}
