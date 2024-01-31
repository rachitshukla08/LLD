package fooddeliverysystem.searcher;
import fooddeliverysystem.data.*;
import fooddeliverysystem.filters.RestaurantFilter;
import fooddeliverysystem.data.DataAccessor;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcher {
    public List<Restaurant> search(String restaurantName, List<RestaurantFilter> filters){
        if(restaurantName == null || restaurantName.length()==0 || filters == null)
            throw new IllegalArgumentException("Missing search params");
        DataAccessResults dataAccessResults = DataAccessor.getRestaurantsWithName(restaurantName);
        List<Restaurant> restaurants = DataAccessObjectConverter.convertToRestaurants(dataAccessResults);
        for(RestaurantFilter filter: filters){
            List<Restaurant> filteredRestaurants = new ArrayList<>();
            for(Restaurant restaurant: restaurants){
                if(filter.filter(restaurant)){
                    filteredRestaurants.add(restaurant);
                }
            }
            restaurants = filteredRestaurants;
        }
        return restaurants;
    }

    public Restaurant searchById(int id) {
        if(id < 0)
            throw new IllegalArgumentException("Missing search params");

        return null;
    }
}
