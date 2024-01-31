package fooddeliverysystem.managers;

import fooddeliverysystem.data.*;
import fooddeliverysystem.factory.PermissionFactory;
import fooddeliverysystem.permission.Permission;

import java.util.List;

public class CartManager {
    public List<CartItem> getUserCart(User user) {
        DataAccessResults dataAccessResults = DataAccessor.getCart(user);
        return DataAccessObjectConverter.convertToCartItem(dataAccessResults);
    }

    public void addItemToCart(User user, FoodItem foodItem){
        Permission permission = PermissionFactory.getAddToCartPermission(user, foodItem);
        if(!permission.isPermitted())
            throw new RuntimeException("Permission denied");
        if(!isFoodItemFromSameRestaurant(user, foodItem))
            throw new RuntimeException("Cart contains items from " +
                "different restaurants");
        // add to DB
        DataAccessor.addItemToCart(user, foodItem);
    }

    public void deleteItemFromCart(User user, FoodItem foodItem){
        Permission permission = PermissionFactory.getAddToCartPermission(user, foodItem);
        if(!permission.isPermitted())
            throw new RuntimeException("Permission denied");
        if(!isFoodItemPresentInCart(user,foodItem))
            throw new RuntimeException("Food item not present in cart");
        DataAccessor.deleteItemFromCart(user, foodItem);
    }

    public void checkOutUserCart(User user){
        Permission permission = PermissionFactory.getCheckoutCartPermission(user);
        if(!permission.isPermitted())
            throw new RuntimeException("Permission denied");
        if(isCartEmpty(user))
            throw new RuntimeException("Cart is empty");
        DataAccessor.checkoutCart(user);
    }

    private boolean isFoodItemFromSameRestaurant(User user, FoodItem foodItem) {
        List<CartItem> cartItems = this.getUserCart(user);
        if(cartItems.isEmpty())
            return true;
        return cartItems.get(0).getFoodItem().getRestaurantId() == foodItem.getRestaurantId();
    }

    private boolean isFoodItemPresentInCart(User user, FoodItem foodItem) {
        List<CartItem> cartItems = this.getUserCart(user);
        for(CartItem cartItem: cartItems){
            if(cartItem.getFoodItem().getId() == foodItem.getId())
                return true;
        }
        return false;
    }

    private boolean isCartEmpty(User user){
        List<CartItem> cartItems = this.getUserCart(user);
        if(cartItems.isEmpty()) return true;
        return false;
    }
}
