package stocktrading.publisher;

import stocktrading.data.StockName;
import stocktrading.data.StockValue;
import stocktrading.subscriber.StockSubscriber;

public interface StockPublisher {
    void subscribe(StockSubscriber stockSubscriber);
    void unsubscriber(StockSubscriber stockSubscriber);
    void notifySubscribers(StockName stockName, StockValue stockValue);
}
