package fooddeliverysystem.apis;

import fooddeliverysystem.data.CuisineType;
import fooddeliverysystem.data.MealType;
import fooddeliverysystem.data.Restaurant;
import fooddeliverysystem.data.StarRating;
import fooddeliverysystem.filters.CuisinesTypeFilter;
import fooddeliverysystem.filters.MealTypeFilter;
import fooddeliverysystem.filters.RestaurantFilter;
import fooddeliverysystem.searcher.RestaurantSearcher;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsSearcherAPI {
    public List<Restaurant> searchRestaurants(String restaurant, MealType mealType, List<CuisineType> cuisineTypes, StarRating rating) {
        //validate parameters
        List<RestaurantFilter> restaurantFilters = new ArrayList<>();
        if(mealType != null) restaurantFilters.add(new MealTypeFilter(mealType));
        if(cuisineTypes != null) restaurantFilters.add(new CuisinesTypeFilter(cuisineTypes));
        if(rating != null) restaurantFilters.add(new CuisinesTypeFilter(cuisineTypes));
        return new RestaurantSearcher().search(restaurant, restaurantFilters);
    }
}
