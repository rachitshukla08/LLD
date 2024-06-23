package designpatterns.hard.six_ecommerce.apis;

import designpatterns.hard.six_ecommerce.cart.CartManager;
import designpatterns.hard.six_ecommerce.data.ProductCopy;
import designpatterns.hard.six_ecommerce.data.User;
import designpatterns.hard.six_ecommerce.database.DBAccessor;
import designpatterns.hard.six_ecommerce.permission.Permission;
import designpatterns.hard.six_ecommerce.permission.PermissionFactory;

import java.util.Optional;

public class AddToCartAPI {
    private final CartManager cartManager;

    public AddToCartAPI(CartManager cartManager) {
        this.cartManager = cartManager;
    }

    public void addToCart(int productId, User user) {
        ProductCopy productCopy = DBAccessor.getProductCopyById(productId);
        if(productCopy == null)
            throw new RuntimeException("No such product found");
        Optional<Permission> permission = PermissionFactory.getAddToCartPermission(user, productCopy);
        if(!permission.isPresent() || !permission.get().isPermitted())
            throw new RuntimeException("Add to cart permission doesnt exist for this user/product");
        this.cartManager.addToCart(user, productCopy);
    }
}
