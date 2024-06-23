package designpatterns.hard.six_ecommerce.filter;

import designpatterns.hard.six_ecommerce.data.Product;
import designpatterns.hard.six_ecommerce.data.Rating;

import java.util.ArrayList;
import java.util.List;

public class RatingFilter implements ProductFilter{
    private final Rating rating;
    private final ProductFilter nextFilter;

    public RatingFilter(Rating rating, ProductFilter nextFilter) {
        this.rating = rating;
        this.nextFilter = nextFilter;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredProducts = nextFilter.filter(products);
        List<Product> finalProducts = new ArrayList<>();
        for(Product product: filteredProducts){
            if(product.getRating().getVal()>= rating.getVal())
                finalProducts.add(product);
        }
        return finalProducts;

    }
}
