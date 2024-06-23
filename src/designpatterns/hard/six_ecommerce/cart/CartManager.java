package designpatterns.hard.six_ecommerce.cart;

import designpatterns.hard.six_ecommerce.data.Cart;
import designpatterns.hard.six_ecommerce.data.Order;
import designpatterns.hard.six_ecommerce.data.ProductCopy;
import designpatterns.hard.six_ecommerce.data.User;
import designpatterns.hard.six_ecommerce.database.DBAccessor;

public class CartManager {
    public Cart getCart(User user){
        return DBAccessor.getCart(user);
    }

    public void addToCart(User user, ProductCopy productCopy){
        if(productCopy.isSold())
            throw new RuntimeException("Product already sold");
        Cart cart = this.getCart(user);
        cart.addProductCopy(productCopy);
        DBAccessor.persistCart(cart, user);
    }


    public void removeFromCart(User user, ProductCopy productCopy){
        Cart cart = this.getCart(user);
        cart.removeProductCopy(productCopy);
        DBAccessor.persistCart(cart, user);
    }

    public void checkoutCart(User user, Order order){
        DBAccessor.checkoutCart(user, order);
    }
}
