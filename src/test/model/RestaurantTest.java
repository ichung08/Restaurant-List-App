package model;

import exceptions.NonZeroLengthException;
import exceptions.PriceRangeException;
import exceptions.RatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    private Restaurant testRestaurant;

    @BeforeEach
    void runBefore() {
        testRestaurant = new Restaurant("McDonald's");
    }

    @Test
    void testConstructor() {
        assertEquals("McDonald's", testRestaurant.getName());
    }

    @Test
    void testSetAddress() {
        try {
            testRestaurant.setAddress("123 Number 5 Road Richmond, British Columbia");
            assertEquals("123 Number 5 Road Richmond, British Columbia", testRestaurant.getAddress());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetAddressFail() {
        try {
            testRestaurant.setAddress("");
            fail("Exception should have been caught");
        } catch (NonZeroLengthException e) {
            // Expected
        }
    }

    @Test
    void testSetDescription() {
        try {
            testRestaurant.setDescription("World famous burger and fries!");
            assertEquals("World famous burger and fries!", testRestaurant.getDescription());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetDescriptionFail() {
        try {
            testRestaurant.setDescription("");
            fail("Exception should have been caught");
        } catch (NonZeroLengthException e) {
            // Expected
        }
    }

    @Test
    void testSetRating() {
        try {
            testRestaurant.setRating(5);
            assertEquals(5, testRestaurant.getRating());
        } catch (RatingException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetRatingFail() {
        try {
            testRestaurant.setRating(0);
            fail("Exception should have been caught");
        } catch (RatingException e) {
            // Expected
        }
    }

    @Test
    void testSetCuisineUpper() {
        try {
            testRestaurant.setCuisine("FAST FOOD");
            assertEquals("fast food", testRestaurant.getCuisine());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetCuisine() {
        try {
            testRestaurant.setCuisine("Fast Food");
            assertEquals("fast food", testRestaurant.getCuisine());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetCuisineFail() {
        try {
            testRestaurant.setCuisine("");
            fail("Exception should have been caught");
        } catch (NonZeroLengthException e) {
            // Expected
        }
    }

    @Test
    void testSetLocationUpper() {
        try {
            testRestaurant.setLocation("RICHMOND");
            assertEquals("richmond", testRestaurant.getLocation());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetLocation() {
        try {
            testRestaurant.setLocation("Richmond");
            assertEquals("richmond", testRestaurant.getLocation());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetLocationFail() {
        try {
            testRestaurant.setLocation("");
            fail("Exception should have been caught");
        } catch (NonZeroLengthException e) {
            // Expected
        }
    }

    @Test
    void testSetPriceRange() {
        try {
            testRestaurant.setPriceRange(1);
            assertEquals(1, testRestaurant.getPriceRange());
        } catch (PriceRangeException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSetPriceRangeFail() {
        try {
            testRestaurant.setPriceRange(5);
            fail("Exception should have been caught");
        } catch (PriceRangeException e) {
            // Expected
        }
    }

    @Test
    void testToString() {
        assertEquals("McDonald's", testRestaurant.toString());
    }





}