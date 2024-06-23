package designpatterns.hard.six_ecommerce.apis;

import designpatterns.hard.six_ecommerce.data.FilterDetails;
import designpatterns.hard.six_ecommerce.data.Product;
import designpatterns.hard.six_ecommerce.data.User;
import designpatterns.hard.six_ecommerce.permission.Permission;
import designpatterns.hard.six_ecommerce.permission.PermissionFactory;
import designpatterns.hard.six_ecommerce.searcher.ProductSearcher;

import java.util.List;
import java.util.Optional;

public class SearchProductAPI {
    private final ProductSearcher productSearcher;
    public SearchProductAPI(ProductSearcher productSearcher) {
        this.productSearcher = productSearcher;
    }
    public List<Product> search(String productName, FilterDetails filterDetails, User user){
        // Data validation and cleaning of arguments
        Optional<Permission> permission = PermissionFactory.getSearchPermission(user);
        if(!permission.isPresent() || !permission.get().isPermitted()){
            throw new RuntimeException("Search not allowed");
        }
        return productSearcher.searchProducts(productName, filterDetails);
    }
}
