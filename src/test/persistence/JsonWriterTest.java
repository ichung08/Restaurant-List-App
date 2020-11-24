package persistence;

import model.Restaurant;
import model.RestaurantList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Reference to JsonSerializationDemo Tests
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            RestaurantList restaurantList = new RestaurantList("My Restaurant List");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyRestaurantList() {
        try {
            RestaurantList restaurantList = new RestaurantList("My Restaurant List");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyRestaurantList.json");
            writer.open();
            writer.write(restaurantList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyRestaurantList.json");
            restaurantList = reader.read();
            assertEquals("My Restaurant List", restaurantList.getName());
            assertEquals(0, restaurantList.length());
        } catch (Exception e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralRestaurantList() {
        try {
            RestaurantList restaurantList = new RestaurantList("My Restaurant List");

            Restaurant r = new Restaurant("McDonald's");
            r.setAddress("1234 Number 5 Rd. Richmond, British Columbia");
            r.setDescription("World famous burger and fries!");
            r.setRating(5);
            r.setLocation("richmond");
            r.setPriceRange(1);
            r.setCuisine("fast food");

            restaurantList.addRestaurant(r);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralRestaurantList.json");
            writer.open();
            writer.write(restaurantList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralRestaurantList.json");
            restaurantList = reader.read();
            assertEquals("My Restaurant List", restaurantList.getName());
            assertEquals(1, restaurantList.length());
            checkRestaurant("McDonald's",
                            "1234 Number 5 Rd. Richmond, British Columbia",
                            5,
                            "World famous burger and fries!",
                            "fast food",
                            "richmond",
                            1,
                                    restaurantList.getRestaurant(0));

        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }
}

