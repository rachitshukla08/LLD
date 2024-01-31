package fooddeliverysystem.data;

public class FoodItem {
    private final int id;
    private final String name;
    private final String description;
    private final double price;
    private final MealType mealType;
    private final StarRating rating;
    private final CuisineType cuisineType;
    private final int restaurantId;
    private boolean isAvailable;

    public FoodItem(int id, String name, String description, double price, MealType mealType,
                    StarRating rating, CuisineType cuisineType, int restaurantId, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.mealType = mealType;
        this.rating = rating;
        this.cuisineType = cuisineType;
        this.restaurantId = restaurantId;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public MealType getMealType() {
        return mealType;
    }

    public StarRating getRating() {
        return rating;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
