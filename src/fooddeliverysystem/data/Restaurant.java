package fooddeliverysystem.data;

import java.util.List;

public class Restaurant {
    private final int id;
    private final String name;
    private final String description;
    private final BusinessHours businessHours;
    private final MealType mealType;
    private final StarRating rating;
    private final List<CuisineType> cuisineType;
    private final Menu menu;
    private final Address address;

    public Restaurant(int id, String name, String description, BusinessHours businessHours,
                      MealType mealType, StarRating rating, List<CuisineType> cuisineType, Menu menu, Address address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.businessHours = businessHours;
        this.mealType = mealType;
        this.rating = rating;
        this.cuisineType = cuisineType;
        this.menu = menu;
        this.address = address;
    }

    public Restaurant(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.businessHours = builder.businessHours;
        this.mealType = builder.mealType;
        this.rating = builder.rating;
        this.cuisineType = builder.cuisineType;
        this.menu = builder.menu;
        this.address = builder.address;
    }

    public static class Builder {
        private int id;
        private String name;
        private String description;
        private BusinessHours businessHours;
        private MealType mealType;
        private StarRating rating;
        private List<CuisineType> cuisineType;
        private Menu menu;
        private Address address;

        public Builder(int id, String name, BusinessHours businessHours, Menu menu) {
            this.id = id;
            this.name = name;
            this.businessHours = businessHours;
            this.menu = menu;
        }

        public Builder Description(String description){
            this.description = description;
            return this;
        }

        public Builder Mealtype(MealType mealType){
            this.mealType = mealType;
            return this;
        }

        public Builder Rating(StarRating rating){
            this.rating = rating;
            return this;
        }

        public Builder Cuisines(List<CuisineType> cuisineType){
            this.cuisineType = cuisineType;
            return this;
        }

        public Builder Address(Address address){
            this.address = address;
            return this;
        }

        public Restaurant build(){
            return new Restaurant(this);
        }
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

    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    public MealType getMealType() {
        return mealType;
    }

    public StarRating getRating() {
        return rating;
    }

    public List<CuisineType> getCuisineType() {
        return cuisineType;
    }

    public Address getAddress() {
        return address;
    }

    public Menu getMenu() {
        return menu;
    }
}
