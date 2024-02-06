package stocktrading.subscriber;

import stocktrading.data.StockName;
import stocktrading.data.StockValue;
import stocktrading.publisher.StockPublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockUpdatesSubscriber implements StockSubscriber{
    private final String name;
    private Map<StockName, StockValue> stockValues;
    private List<StockPublisher> publishers;

    public StockUpdatesSubscriber(String name) {
        this.name = name;
        this.stockValues = new HashMap<>();
        this.publishers = new ArrayList<>();
    }

    @Override
    public void updateStock(StockName stockName, StockValue stockValue) {

        if(!this.stockValues.containsKey(stockName) ||
                stockValues.get(stockName).getVersion() < stockValue.getVersion()){
            this.stockValues.put(stockName, stockValue);
            System.out.println(name + " " + stockName + " " + stockValue.getCurrency() + " " +stockValue.getPrice()
                    + " " + stockValue.getVersion());
        }
    }
}
