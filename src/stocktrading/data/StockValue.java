package stocktrading.data;



public class StockValue {
    private final double price;
    private final int version;
    private final Currency currency;

    public StockValue(double price, int version, Currency currency) {
        this.price = price;
        this.version = version;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public int getVersion() {
        return version;
    }

    public Currency getCurrency() {
        return currency;
    }
}
