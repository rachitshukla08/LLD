package fooddeliverysystem.searcher;

import fooddeliverysystem.data.DataAccessResults;
import fooddeliverysystem.data.DataAccessObjectConverter;
import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.DataAccessor;
import fooddeliverysystem.filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher {
    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) {
        if(foodItemName == null || foodItemName.length()==0 || filters == null)
            throw new IllegalArgumentException("Missing search params");
        DataAccessResults dataAccessResults = DataAccessor.getFoodItemsWithName(foodItemName);
        List<FoodItem> foodItems = DataAccessObjectConverter.convertToFoodItems(dataAccessResults);
        for(FoodItemFilter filter: filters){
            List<FoodItem> filteredFoodItems = new ArrayList<>();
            for(FoodItem foodItem: foodItems){
                if(filter.filter(foodItem)){
                    filteredFoodItems.add(foodItem);
                }
            }
            foodItems = filteredFoodItems;
        }
        return foodItems;
    }

    public FoodItem searchById(int id) {
        if(id < 0)
            throw new IllegalArgumentException("Missing search params");

        return null;
    }
}
