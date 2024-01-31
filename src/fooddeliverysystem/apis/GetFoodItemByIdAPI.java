package fooddeliverysystem.apis;

import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.Restaurant;
import fooddeliverysystem.searcher.FoodItemSearcher;

public class GetFoodItemByIdAPI {

    public FoodItem getFoodItemById(int id) {
        return new FoodItemSearcher().searchById(id);
    }
}
