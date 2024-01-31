package fooddeliverysystem.apis;

import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.User;
import fooddeliverysystem.managers.CartManager;
import fooddeliverysystem.managers.UserManager;
import fooddeliverysystem.searcher.FoodItemSearcher;

public class AddToCartAPI {
    private final UserManager userManager = new UserManager();
    private final FoodItemSearcher foodItemSearcher = new FoodItemSearcher();
    private final CartManager cartManager = new CartManager();

    public void addToCart(String userToken, int foodItemId){
        if(userToken == null || userToken.isEmpty() || foodItemId <0){
            throw new IllegalArgumentException();
        }

        User user = userManager.getUserByToken(userToken);
        if(user == null) throw new RuntimeException("No user found");

        FoodItem foodItem = foodItemSearcher.searchById(foodItemId);
        if(foodItem == null) throw new RuntimeException("No food item found for given id");

        cartManager.addItemToCart(user, foodItem);

    }
}
