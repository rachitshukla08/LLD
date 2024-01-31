package fooddeliverysystem.filters;

import fooddeliverysystem.data.CuisineType;
import fooddeliverysystem.data.FoodItem;
import fooddeliverysystem.data.Restaurant;

import java.util.List;

public class CuisinesTypeFilter implements FoodItemFilter, RestaurantFilter{
    private final List<CuisineType> cuisineTypes;

    public CuisinesTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return this.cuisineTypes.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        List<CuisineType> cuisines = restaurant.getCuisineType();
        for(CuisineType cuisineType: this.cuisineTypes){
            if(cuisines.contains(cuisineType)) return true;
        }
        return false;
    }
}
