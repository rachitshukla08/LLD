package designpatterns.hard.six_ecommerce.data;

import java.util.Optional;

public class FilterDetails {
    private final Optional<Double> priceFilter;
    private final Optional<Rating> ratingFilter;
    private final Optional<Boolean> payOnDeliveryFilter;

    public FilterDetails(Optional<Double> priceFilter, Optional<Rating> ratingFilter, Optional<Boolean> payOnDeliveryFilter) {
        this.priceFilter = priceFilter;
        this.ratingFilter = ratingFilter;
        this.payOnDeliveryFilter = payOnDeliveryFilter;
    }

    public Optional<Double> getPriceFilter() {
        return priceFilter;
    }

    public Optional<Rating> getRatingFilter() {
        return ratingFilter;
    }

    public Optional<Boolean> getPayOnDeliveryFilter() {
        return payOnDeliveryFilter;
    }
}
