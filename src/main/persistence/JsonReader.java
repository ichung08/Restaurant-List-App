package persistence;

import exceptions.NonZeroLengthException;
import exceptions.PriceRangeException;
import exceptions.RatingException;
import model.Restaurant;
import model.RestaurantList;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.transform.Source;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Reference JsonSerializationDemo
// Represents a reader that reads RestaurantList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads RestaurantList from file and returns it
    // throws IOException if an error occurs reading data from file
    public RestaurantList read() throws IOException, RatingException, PriceRangeException, NonZeroLengthException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseRestaurantList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses RestaurantList from JSON object and returns it
    private RestaurantList parseRestaurantList(JSONObject jsonObject)
            throws RatingException, PriceRangeException, NonZeroLengthException {
        String name = jsonObject.getString("name");
        RestaurantList restaurantList = new RestaurantList(name);
        addRestaurants(restaurantList, jsonObject);
        return restaurantList;
    }

    // MODIFIES: RestaurantList
    // EFFECTS: parses restaurants from JSON object and adds them to RestaurantList
    private void addRestaurants(RestaurantList restaurantList, JSONObject jsonObject)
            throws RatingException, PriceRangeException, NonZeroLengthException {
        JSONArray jsonArray = jsonObject.getJSONArray("restaurants");
        for (Object json: jsonArray) {
            JSONObject nextRestaurant = (JSONObject) json;
            addRestaurant(restaurantList, nextRestaurant);
        }
    }

    // MODIFIES: RestaurantList
    // EFFECTS: parses restaurant from JSON object and adds it to RestaurantList
    private void addRestaurant(RestaurantList restaurantList, JSONObject jsonObject)
            throws NonZeroLengthException, RatingException, PriceRangeException {
        String name = jsonObject.getString("name");
        String address = jsonObject.getString("address");
        int rating = jsonObject.getInt("rating");
        String description = jsonObject.getString("description");
        String cuisine = jsonObject.getString("cuisine");
        String location = jsonObject.getString("location");
        int priceRange = jsonObject.getInt("price range");

        Restaurant restaurant = new Restaurant(name);
        restaurant.setAddress(address);
        restaurant.setRating(rating);
        restaurant.setDescription(description);
        restaurant.setCuisine(cuisine);
        restaurant.setLocation(location);
        restaurant.setPriceRange(priceRange);

        restaurantList.addRestaurant(restaurant);

    }




}
