package fooddeliverysystem.permission;

import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.Restaurant;
import fooddeliverysystem.data.User;
import fooddeliverysystem.managers.DeliveryManager;
import fooddeliverysystem.searcher.RestaurantSearcher;

public class AddToCartPermission implements Permission {
    private final User user;
    private final FoodItem foodItem;
    private final DeliveryManager deliveryManager;

    public AddToCartPermission(User user, FoodItem foodItem ) {
        this.user = user;
        this.foodItem = foodItem;
        this.deliveryManager = new DeliveryManager();
    }

    @Override
    public boolean isPermitted() {
        //check if user is allowed to add in cart, if he is blocked or not, etc
        if(!foodItem.isAvailable())
            return false;
        // check if fooditem is deliverable at the address
        Restaurant restaurant = new RestaurantSearcher().searchById(foodItem.getRestaurantId());
        if(!deliveryManager.isDeliveryPossible(restaurant.getAddress(), user.getAddress()))
            return false;
        return true;
    }
}
