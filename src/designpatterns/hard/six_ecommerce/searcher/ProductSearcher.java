package designpatterns.hard.six_ecommerce.searcher;

import designpatterns.hard.six_ecommerce.data.FilterDetails;
import designpatterns.hard.six_ecommerce.data.Product;
import designpatterns.hard.six_ecommerce.database.DBAccessor;
import designpatterns.hard.six_ecommerce.factory.ProductFilterFactory;

import java.util.List;

public class ProductSearcher {
    public List<Product> searchProducts(String productName, FilterDetails filterDetails){
        List<Product> products = DBAccessor.getProductsByName(productName);
        return ProductFilterFactory.getProductFilter(filterDetails).filter(products);
    }
}
