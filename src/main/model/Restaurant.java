package model;

// Represents a restaurant having a name, address, rating, description and a cuisine, location and price tag
public class Restaurant {
    private String name;           // restaurant name
    private String address;        // restaurant address
    private int rating;            // restaurant rating (1 - 5)
    private String description;    // restaurant description
    private String cuisine;        // restaurant cuisine (eg. chinese)
    private String location;       // restaurant city location (eg. vancouver)
    private int priceRange;             // restaurant price range in CAD (1: $1 - $15, 2: $15 - $35, 3: $35 - $60,
    // 4: $60+)

    /*
    REQUIRES: restaurantName has a non-zero length
    EFFECTS: name is set to restaurantName
     */
    public Restaurant(String restaurantName) {
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
    REQUIRES: address has a non-zero length
    MODIFIES: this
    EFFECTS: sets restaurant address to address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /*
    REQUIRES: description has a non-zero length
    MODIFIES: this
    EFFECTS: sets restaurant description to description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
    REQUIRES: rating is >= 1 and <=5
    MODIFIES: this
    EFFECTS: sets restaurant rating to rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /*
   REQUIRES: cuisine has a non-zero length
   MODIFIES: this
   EFFECTS: sets restaurant cuisine to cuisine
    */
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    /*
    REQUIRES: city has a non-zero length
    MODIFIES: this
    EFFECTS: sets restaurant city location to city
     */
    public void setLocation(String city) {
        this.location = city;
    }

    /*
    REQUIRES: price is >= 1 and <= 4
    MODIFIES: this
    EFFECTS: sets restaurant priceRange to priceRange
     */
    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

}
