package fooddeliverysystem.apis;

import fooddeliverysystem.data.CuisineType;
import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.MealType;
import fooddeliverysystem.data.StarRating;
import fooddeliverysystem.filters.CuisinesTypeFilter;
import fooddeliverysystem.filters.FoodItemFilter;
import fooddeliverysystem.filters.MealTypeFilter;
import fooddeliverysystem.filters.StarRatingFilter;
import fooddeliverysystem.searcher.FoodItemSearcher;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcherAPI {
    public List<FoodItem> searchFoodItem(String foodItemName, MealType mealType, List<CuisineType> cuisines,
                                         StarRating rating) {
        List<FoodItemFilter> filters = new ArrayList<>();
        if(mealType != null) filters.add(new MealTypeFilter(mealType));
        if(cuisines != null) filters.add(new CuisinesTypeFilter(cuisines));
        if(rating != null) filters.add(new StarRatingFilter(rating));
        FoodItemSearcher foodItemSearcher = new FoodItemSearcher();
        return foodItemSearcher.search(foodItemName, filters);
    }
}
