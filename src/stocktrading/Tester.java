package stocktrading;

import stocktrading.data.Currency;
import stocktrading.data.StockName;
import stocktrading.data.StockValue;
import stocktrading.publisher.StockPublisher;
import stocktrading.publisher.StockUpdatesPublisher;
import stocktrading.subscriber.StockSubscriber;
import stocktrading.subscriber.StockUpdatesSubscriber;

public class Tester {
    public static void main(String[] args) {
        StockPublisher bsePublisher = new StockUpdatesPublisher("BSE");
        StockPublisher nsePublisher = new StockUpdatesPublisher("NSE");
        StockSubscriber subscriber1 = new StockUpdatesSubscriber("Subscriber 1");
        StockSubscriber subscriber2 = new StockUpdatesSubscriber("Subscriber 2");
        StockSubscriber subscriber3 = new StockUpdatesSubscriber("Subscriber 3");
        nsePublisher.subscribe(subscriber1);
        nsePublisher.subscribe(subscriber2);
        bsePublisher.subscribe(subscriber3);
        bsePublisher.subscribe(subscriber2);
        nsePublisher.notifySubscribers(StockName.AMAZON, new StockValue(1000, 1, Currency.RUPEES));
        nsePublisher.notifySubscribers(StockName.AMAZON, new StockValue(2000, 2, Currency.RUPEES));
        bsePublisher.notifySubscribers(StockName.AMAZON, new StockValue(1000, 1, Currency.RUPEES));
        bsePublisher.notifySubscribers(StockName.NETFLIX, new StockValue(300, 1, Currency.RUPEES));
    }
}
