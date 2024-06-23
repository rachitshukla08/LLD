package designpatterns.hard.six_ecommerce.data;

public class Product {
    private final String name;
    private final int id;
    private final String description;
    private final double priceINR;
    private final Rating rating;
    private final boolean isPayOnDelivery;

    public Product(String name, int id, String description, double priceINR, Rating rating, boolean isPayOnDelivery) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.priceINR = priceINR;
        this.rating = rating;
        this.isPayOnDelivery = isPayOnDelivery;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceINR() {
        return priceINR;
    }

    public Rating getRating() {
        return rating;
    }

    public boolean isPayOnDelivery() {
        return isPayOnDelivery;
    }
}
