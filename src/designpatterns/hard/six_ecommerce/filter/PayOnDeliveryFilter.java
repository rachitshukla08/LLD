package designpatterns.hard.six_ecommerce.filter;

import designpatterns.hard.six_ecommerce.data.Product;

import java.util.ArrayList;
import java.util.List;

public class PayOnDeliveryFilter implements ProductFilter{
    private final ProductFilter nextFilter;
    private final boolean isPayOnDelivery;

    public PayOnDeliveryFilter( boolean isPayOnDelivery, ProductFilter nextFilter) {
        this.nextFilter = nextFilter;
        this.isPayOnDelivery = isPayOnDelivery;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredProducts  = nextFilter.filter(products);
        List<Product> finalProducts = new ArrayList<>();
        for(Product product: filteredProducts){
            if(product.isPayOnDelivery() == isPayOnDelivery)
                finalProducts.add(product);
        }
        return finalProducts;
    }
}
