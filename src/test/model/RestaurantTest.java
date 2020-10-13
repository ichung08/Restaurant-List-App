package model;

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
        testRestaurant.setAddress("123 Number 5 Road Richmond, British Columbia");
        assertEquals("123 Number 5 Road Richmond, British Columbia", testRestaurant.getAddress());
    }

    @Test
    void testSetDescription() {
        testRestaurant.setDescription("World famous burger and fries!");
        assertEquals("World famous burger and fries!", testRestaurant.getDescription());
    }

    @Test
    void testSetRating() {
        testRestaurant.setRating(5);
        assertEquals(5, testRestaurant.getRating());
    }

    @Test
    void testSetCuisine() {
        testRestaurant.setCuisine("fast food");
        assertEquals("fast food", testRestaurant.getCuisine());
    }

    @Test
    void testSetLocation() {
        testRestaurant.setLocation("richmond");
        assertEquals("richmond", testRestaurant.getLocation());
    }

    @Test
    void testSetPriceRange() {
        testRestaurant.setPriceRange(1);
        assertEquals(1, testRestaurant.getPriceRange());
    }







}