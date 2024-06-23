package designpatterns.hard.six_ecommerce.permission;

import designpatterns.hard.six_ecommerce.data.Cart;
import designpatterns.hard.six_ecommerce.data.ProductCopy;
import designpatterns.hard.six_ecommerce.data.User;
import designpatterns.hard.six_ecommerce.database.DBAccessor;

public class AddToCartPermission implements Permission{
    private static final double MAX_CART_AMOUNT = 1000000;
    private static final int DISTINCT_ITEMS_LIMIT = 50;
    private static final int TOTAL_ITEMS = 1000;
    private final User user;
    private final ProductCopy productCopy;

    public AddToCartPermission(User user, ProductCopy productCopy) {
        this.user = user;
        this.productCopy = productCopy;
    }

    @Override
    public boolean isPermitted() {
        Cart cart = DBAccessor.getCart(user);
        if(cart.getCartAmount()>MAX_CART_AMOUNT || cart.getDistinctItemsCount() > DISTINCT_ITEMS_LIMIT ||
        cart.getTotalItemsCount() > TOTAL_ITEMS)
            return false;
        return true;
    }
}
