package designpatterns.hard.six_ecommerce.factory;

import designpatterns.hard.six_ecommerce.data.FilterDetails;
import designpatterns.hard.six_ecommerce.filter.*;

public class ProductFilterFactory {
    private ProductFilterFactory(){}

    public static ProductFilter getProductFilter(FilterDetails filterDetails){
        ProductFilter filter = new IdleFilter();
        if(filterDetails.getRatingFilter().isPresent()) {
            filter = new RatingFilter(filterDetails.getRatingFilter().get(),filter );
        }
        if(filterDetails.getPayOnDeliveryFilter().isPresent()){
            filter = new PayOnDeliveryFilter(filterDetails.getPayOnDeliveryFilter().get(), filter);
        }
        if(filterDetails.getPriceFilter().isPresent()){
            filter = new PriceFilter(filterDetails.getPriceFilter().get(), filter);
        }
        return filter;
    }
}
