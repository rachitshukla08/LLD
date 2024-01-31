package fooddeliverysystem.apis;

import fooddeliverysystem.data.Restaurant;
import fooddeliverysystem.searcher.RestaurantSearcher;

public class GetRestaurantByIdAPI {

    public Restaurant getRestaurantById(int id) {
        return new RestaurantSearcher().searchById(id);
    }
}
