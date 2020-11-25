package model;

import exceptions.NonZeroLengthException;
import exceptions.PriceRangeException;
import exceptions.RatingException;
import org.json.JSONObject;
import persistence.Writable;

// Represents a restaurant having a name, address, rating, description and a cuisine, location and price tag
public class Restaurant implements Writable {
    private String name;           // restaurant name
    private String address;        // restaurant address
    private int rating;            // restaurant rating (1 - 5)
    private String description;    // restaurant description
    private String cuisine;        // restaurant cuisine (eg. chinese)
    private String location;       // restaurant city location (eg. vancouver)
    private int priceRange;             // restaurant price range in CAD (1: $1 - $15, 2: $15 - $35, 3: $35 - $60,
    // 4: $60+)

    /*
    EFFECTS: if restaurantName has a non-zero length, throws NonZeroLengthException
             otherwise, name is set to restaurantName
     */
    public Restaurant(String restaurantName) throws NonZeroLengthException {
        if (restaurantName.length() == 0) {
            throw new NonZeroLengthException();
        }
        name = restaurantName;
        address = "";
        rating = 0;
        description = "";
        cuisine = "";
        location = "";
        priceRange = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getLocation() {
        return location;
    }

    public int getPriceRange() {
        return priceRange;
    }

    /*
    MODIFIES: this
    EFFECTS: if address has a non-zero length, throws NonZeroLengthException
             otherwise, sets restaurant address to address
     */
    public void setAddress(String address) throws NonZeroLengthException {
        if (address.length() == 0) {
            throw new NonZeroLengthException();
        }
        this.address = address;
    }

    /*
    MODIFIES: this
    EFFECTS: if description has a non-zero length, throws NonZeroLengthException
             otherwise, sets restaurant description to description
     */
    public void setDescription(String description) throws NonZeroLengthException {
        if (description.length() == 0) {
            throw new NonZeroLengthException();
        }
        this.description = description;
    }

    /*
    MODIFIES: this
    EFFECTS: if rating is >=1 and <= 5, throws RatingException
             otherwise, sets restaurant rating to rating
     */
    public void setRating(int rating) throws RatingException {
        if (rating < 1 || rating > 5 || Integer.toString(rating).length() == 0) {
            throw new RatingException();
        }
        this.rating = rating;
    }

    /*
   MODIFIES: this
   EFFECTS: if cuisine has a non-zero length, throws NonZeroLengthException
            otherwise, sets restaurant cuisine to cuisine
    */
    public void setCuisine(String cuisine) throws NonZeroLengthException {
        if (cuisine.length() == 0) {
            throw new NonZeroLengthException();
        }
        this.cuisine = cuisine.toLowerCase();
    }

    /*
    MODIFIES: this
    EFFECTS: if city has a non-zero length, throws NonZeroLengthException
             otherwise, sets restaurant city location to city
     */
    public void setLocation(String city) throws NonZeroLengthException {
        if (city.length() == 0) {
            throw new NonZeroLengthException();
        }
        this.location = city.toLowerCase();
    }

    /*
    MODIFIES: this
    EFFECTS: if price is >= 1 and <= 4, throws PriceRangeException
             otherwise, sets restaurant priceRange to priceRange
     */
    public void setPriceRange(int priceRange) throws PriceRangeException {
        if (priceRange < 1 || priceRange > 4 || Integer.toString(priceRange).length() == 0) {
            throw new PriceRangeException();
        }
        this.priceRange = priceRange;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("address", address);
        json.put("rating", rating);
        json.put("description", description);
        json.put("cuisine", cuisine);
        json.put("location", location);
        json.put("price range", priceRange);
        return json;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
