package designpatterns.hard.six_ecommerce.database;

import designpatterns.hard.six_ecommerce.data.*;
import designpatterns.hard.six_ecommerce.order.OrderState;

import java.util.List;

public class DBAccessor {
    private DBAccessor(){}
    public static List<Product> getProductsByName(String productName){
        return null;
    }

    public static ProductCopy getProductCopyById(int productId) {
        // Fetches the product copy from DB and returns it
        return null;
    }

    public static Cart getCart(User user){
        //get the user id, get user details, fetch cart from DB for that id, create the cart and return it
        return null;
    }

    public static void persistCart(Cart cart, User user){

    }

    public static void checkoutCart(User user, Order order){

    }

    public static Order getOrderByOrderId(int orderId){
        return null;
    }

    public static OrderState getOrderState(int id) {
        return null;
    }
}
