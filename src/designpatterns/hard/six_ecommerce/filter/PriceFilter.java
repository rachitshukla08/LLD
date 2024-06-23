package designpatterns.hard.six_ecommerce.filter;

import designpatterns.hard.six_ecommerce.data.Product;

import java.util.ArrayList;
import java.util.List;

public class PriceFilter implements ProductFilter{
    private final double priceUpperCap;
    private final ProductFilter nextFilter;

    public PriceFilter(double priceUpperCap, ProductFilter nextFilter) {
        this.priceUpperCap = priceUpperCap;
        this.nextFilter = nextFilter;
    }


    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredProducts = nextFilter.filter(products);
        List<Product> finalProducts = new ArrayList<>();
        for(Product product: filteredProducts){
            if(product.getPriceINR()<= priceUpperCap)
                finalProducts.add(product);
        }
        return finalProducts;
    }
}
