package designpatterns.hard.six_ecommerce.publisher;

import designpatterns.hard.six_ecommerce.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusPublisher implements Publisher {
    private final List<Subscriber> subscribers;

    public OrderStatusPublisher() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(this.subscribers.contains(subscriber))
            throw new RuntimeException();
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(!this.subscribers.contains(subscriber))
            throw new RuntimeException();
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifyAll(String message) {
        for(Subscriber subscriber: subscribers){
            subscriber.notify(message);
        }
    }
}
