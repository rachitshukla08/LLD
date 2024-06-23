package designpatterns.hard.six_ecommerce.publisher;

import designpatterns.hard.six_ecommerce.subscriber.Subscriber;

public interface Publisher {

    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifyAll(String message);
}
