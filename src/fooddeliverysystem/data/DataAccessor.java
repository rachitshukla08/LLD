package fooddeliverysystem.data;

import java.util.List;

public class DataAccessor {
    private DataAccessor(){

    }

    public static void addItemToCart(User user, FoodItem foodItem){

    }

    public static DataAccessResults getFoodItemsWithName(String name){
        return null;
    }

    public static DataAccessResults getRestaurantsWithName(String name) {
        return null;
    }

    public static DataAccessResults getCart(User user){
        return null;
    }

    public static void deleteItemFromCart(User user, FoodItem foodItem) {
    }

    public static void checkoutCart(User user){}

    public static int createOrder(User user, List<CartItem> cartItems){
        return 1;
    }

    public static void updateOrderStatus(Order order, OrderStatus status){}
}
