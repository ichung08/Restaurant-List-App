package persistence;

import model.Restaurant;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkRestaurant(String name, String address, int rating, String description,
                                   String cuisine, String location, int priceRange, Restaurant
                                   restaurant) {
        assertEquals(name, restaurant.getName());
        assertEquals(address, restaurant.getAddress());
        assertEquals(rating, restaurant.getRating());
        assertEquals(description, restaurant.getDescription());
        assertEquals(cuisine, restaurant.getCuisine());
        assertEquals(location, restaurant.getLocation());
        assertEquals(priceRange, restaurant.getPriceRange());
    }
}
