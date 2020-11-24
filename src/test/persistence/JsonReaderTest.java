package persistence;

import model.RestaurantList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            RestaurantList restaurantList = reader.read();
            fail("IOException expected");
        } catch (Exception e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyRestaurantList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyRestaurantList.json");
        try {
            RestaurantList restaurantList = reader.read();
            assertEquals("My Restaurant List", restaurantList.getName());
            assertEquals(0, restaurantList.length());
        } catch (Exception e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralRestaurantList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralRestaurantList.json");
        try {
            RestaurantList restaurantList = reader.read();
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
            fail("Couldn't read from file");
        }
    }
}
