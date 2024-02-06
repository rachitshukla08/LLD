package stocktrading.publisher;

import stocktrading.data.StockName;
import stocktrading.data.StockValue;
import stocktrading.subscriber.StockSubscriber;

import java.util.ArrayList;
import java.util.List;

public class StockUpdatesPublisher implements StockPublisher{
    private final String name;
    private List<StockSubscriber> stockSubscribers;

    public StockUpdatesPublisher(String name) {
        this.name = name;
        stockSubscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(StockSubscriber stockSubscriber) {
        this.stockSubscribers.add(stockSubscriber);
    }

    @Override
    public void unsubscriber(StockSubscriber stockSubscriber) {
        this.stockSubscribers.remove(stockSubscriber);
    }

    @Override
    public void notifySubscribers(StockName stockName, StockValue stockValue) {
        for(StockSubscriber subscriber: this.stockSubscribers){
            subscriber.updateStock(stockName, stockValue);
        }
    }
}
