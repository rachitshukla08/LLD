package designpatterns.hard.six_ecommerce.permission;

import designpatterns.hard.six_ecommerce.data.Order;
import designpatterns.hard.six_ecommerce.data.ProductCopy;
import designpatterns.hard.six_ecommerce.data.User;

import java.util.Optional;

public class PermissionFactory {
    private PermissionFactory(){}
    public static Optional<Permission> getSearchPermission(User user){
        //Query DB for the user id and search for user ID in permission table
        //constructs and returns permission
        return Optional.of(new SearchProductPermission(user));
    }

    public static Optional<Permission> getAddToCartPermission(User user, ProductCopy productCopy){
        //Query DB for the user id and search for user ID in permission table
        //constructs and returns AddToCartPermission
        return Optional.of(new AddToCartPermission(user, productCopy));
    }

    public static Optional<Permission> getTrackOrderPermission(User user, Order order){
        return Optional.of(new TrackOrderPermission(user, order));
    }
}
