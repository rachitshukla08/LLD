package fooddeliverysystem.factory;

import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.Order;
import fooddeliverysystem.data.OrderStatus;
import fooddeliverysystem.data.User;
import fooddeliverysystem.permission.*;

public class PermissionFactory {
    private PermissionFactory(){}

    public static Permission getAddToCartPermission(User user, FoodItem foodItem){
        return new AddToCartPermission(user, foodItem);
    }

    public static Permission getDeleteFromCartPermission(User user, FoodItem foodItem) {
        return new DeleteFromCartPermission(user, foodItem);
    }

    public static Permission getCheckoutCartPermission(User user){
        return new CheckoutCartPermission(user);
    }

    public static Permission getPlaceOrderPermission(User user) {
        return new PlaceOrderPermission(user);
    }

    public static Permission getUpdateOrderPermission(User user, Order order, OrderStatus orderStatus){
        return new UpdateOrderPermission(user, order, orderStatus);
    }
}
