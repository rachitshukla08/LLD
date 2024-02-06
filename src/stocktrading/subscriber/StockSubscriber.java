package stocktrading.subscriber;

import stocktrading.data.StockName;
import stocktrading.data.StockValue;

public interface StockSubscriber {
    void updateStock(StockName stockName, StockValue stockValue);
}
