package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Represents a list of restaurants
public class RestaurantList {
    private List<Restaurant> restaurantList = new ArrayList<>();

    // EFFECTS:RestaurantList is an empty list with no restaurants
    public RestaurantList() {

    }

    /*
    MODIFIES: this
    EFFECTS: adds a restaurant to the end of the list
     */
    public void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    /*
    MODIFIES: this
    EFFECTS: removes a restaurant from the list of index i
     */
    public void removeRestaurant(int i) {
        restaurantList.remove(i);
    }

    /*
    MODIFIES: this
    EFFECTS: returns a restaurant from the list of index i
     */
    public Restaurant getRestaurant(int i) {
        return restaurantList.get(i);
    }

    /*
    REQUIRES: cuisine has non-zero length
    MODIFIES: this
    EFFECTS: returns a list of restaurants of a certain cuisine
     */
    public RestaurantList sortRestaurantCuisine(String cuisine) {
        RestaurantList cuisineList = new RestaurantList();

        for (Restaurant r: restaurantList) {
            if (r.getCuisine().equals(cuisine)) {
                cuisineList.addRestaurant(r);
            }
        }

        return cuisineList;
    }

    /*
    REQUIRES: location has non-zero length
    MODIFIES: this
    EFFECTS: returns a list of restaurants of a certain location
     */
    public RestaurantList sortRestaurantLocation(String location) {
        RestaurantList locationList = new RestaurantList();

        for (Restaurant r: restaurantList) {
            if (r.getLocation().equals(location)) {
                locationList.addRestaurant(r);
            }
        }

        return locationList;

    }

    /*
    REQUIRES: priceRange must be >= 1 and <= 4
    MODIFIES: this
    EFFECTS: returns a list of restaurants of a certain princeRange
     */
    public RestaurantList sortRestaurantPrice(int priceRange) {
        RestaurantList priceList = new RestaurantList();

        for (Restaurant r: restaurantList) {
            if (r.getPriceRange() == priceRange) {
                priceList.addRestaurant(r);
            }
        }

        return priceList;

    }

    /*
    REQUIRES: restaurantList cannot be empty
    MODIFIES: this
    EFFECTS: returns a random restaurant from a list of restaurants
    */
    public Restaurant returnRandomRestaurant() {
        Random rand = new Random();
        int num = rand.nextInt(restaurantList.size());

        return restaurantList.get(num);

    }

    /*
    REQUIRES: restaurantList cannot be empty and cuisine has non-zero length
    MODIFIES: this
    EFFECTS: returns a random restaurant from a list of restaurants sorted by cuisine
    */
    public Restaurant returnRandomRestaurantCuisine(String cuisine) {
        Random rand = new Random();
        RestaurantList list = sortRestaurantCuisine(cuisine);
        int num = rand.nextInt(list.length());

        return list.getRestaurant(num);

    }

    /*
    REQUIRES: restaurantList cannot be empty and location has non-zero length
    MODIFIES: this
    EFFECTS: returns a random restaurant from a list of restaurants sorted by location
     */
    public Restaurant returnRandomRestaurantLocation(String location) {
        Random rand = new Random();
        RestaurantList list = sortRestaurantLocation(location);
        int num = rand.nextInt(list.length());

        return list.getRestaurant(num);

    }

    /*
     REQUIRES: restaurantList cannot be empty and priceRange is >= 1 and <= 4
     MODIFIES: this
     EFFECTS: returns a random restaurant from a list of restaurants sorted by priceRange
     */
    public Restaurant returnRandomRestaurantPrice(int priceRange) {
        Random rand = new Random();
        RestaurantList list = sortRestaurantPrice(priceRange);
        int num = rand.nextInt(list.length());

        return list.getRestaurant(num);

    }

    // MODIFIES: this
    // EFFECTS: returns an integer that represents the number of restaurants in restaurant list
    public int length() {
        return restaurantList.size();
    }
}
