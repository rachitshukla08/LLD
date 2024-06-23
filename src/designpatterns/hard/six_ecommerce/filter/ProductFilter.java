package designpatterns.hard.six_ecommerce.filter;

import designpatterns.hard.six_ecommerce.data.Product;

import java.util.List;

public interface ProductFilter {
    List<Product> filter(List<Product> products);
}
