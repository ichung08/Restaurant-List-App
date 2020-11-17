package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantListTest {
    private RestaurantList testRestaurantList;

    @BeforeEach
    void runBefore() {
        testRestaurantList = new RestaurantList("My Restaurant List");

    }

    @Test
    void testConstructor() {
        assertEquals(0, testRestaurantList.length());
        assertEquals("My Restaurant List", testRestaurantList.getName());
    }

    @Test
    void testAddRestaurant() {
        Restaurant r1 = new Restaurant("Lotus");
        testRestaurantList.addRestaurant(r1);
        assertEquals(1, testRestaurantList.length());
    }

    @Test
    void testRemoveRestaurantOne() {
        Restaurant r1 = new Restaurant("Lotus");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.removeRestaurant(0);

        assertEquals(0, testRestaurantList.length());
    }

    @Test
    void testRemoveRestaurantMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);
        testRestaurantList.removeRestaurant(1);

        assertEquals(2, testRestaurantList.length());
    }

    @Test
    void testGetRestaurantOne() {
        Restaurant r1 = new Restaurant("Lotus");

        testRestaurantList.addRestaurant(r1);
        assertEquals(r1, testRestaurantList.getRestaurant(0));
    }

    @Test
    void testGetRestaurantMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);
        assertEquals(r3, testRestaurantList.getRestaurant(2));
    }

    @Test
    void testGetRestaurantList() {
        assertEquals(0, testRestaurantList.getRestaurantList().size());
    }

    @Test
    void testSortRestaurantCuisineNone() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setCuisine("vietnamese");
        r2.setCuisine("western");
        r3.setCuisine("chinese");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList Japanese = testRestaurantList.sortRestaurantCuisine("japanese");
        assertEquals(0, Japanese.length());

    }

    @Test
    void testSortRestaurantCuisineOne() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setCuisine("vietnamese");
        r2.setCuisine("western");
        r3.setCuisine("chinese");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList Chinese = testRestaurantList.sortRestaurantCuisine("chinese");
        assertEquals(1, Chinese.length());

    }

    @Test
    void testSortRestaurantCuisineMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setCuisine("chinese");
        r2.setCuisine("western");
        r3.setCuisine("chinese");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList Chinese = testRestaurantList.sortRestaurantCuisine("chinese");
        assertEquals(2, Chinese.length());
    }

    @Test
    void testSortRestaurantLocationNone() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setLocation("vancouver");
        r2.setLocation("richmond");
        r3.setLocation("delta");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList Surrey = testRestaurantList.sortRestaurantLocation("surrey");
        assertEquals(0, Surrey.length());

    }

    @Test
    void testSortRestaurantLocationOne() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setLocation("vancouver");
        r2.setLocation("richmond");
        r3.setLocation("delta");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList Richmond = testRestaurantList.sortRestaurantLocation("richmond");
        assertEquals(1, Richmond.length());

    }

    @Test
    void testSortRestaurantLocationMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setLocation("vancouver");
        r2.setLocation("richmond");
        r3.setLocation("richmond");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList Richmond = testRestaurantList.sortRestaurantLocation("richmond");
        assertEquals(2, Richmond.length());
    }

    @Test
    void testSortRestaurantPriceNone() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setPriceRange(1);
        r2.setPriceRange(2);
        r3.setPriceRange(1);

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList $ = testRestaurantList.sortRestaurantPrice(3);
        assertEquals(0, $.length());

    }

    @Test
    void testSortRestaurantPriceOne() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setPriceRange(1);
        r2.setPriceRange(2);
        r3.setPriceRange(1);

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList $ = testRestaurantList.sortRestaurantPrice(2);
        assertEquals(1, $.length());

    }

    @Test
    void testSortRestaurantPriceMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setPriceRange(1);
        r2.setPriceRange(2);
        r3.setPriceRange(1);

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        RestaurantList $ = testRestaurantList.sortRestaurantPrice(1);
        assertEquals(2, $.length());
    }

    @Test
    void testReturnRandomRestaurantOne() {
        Restaurant r1 = new Restaurant("Lotus");

        testRestaurantList.addRestaurant(r1);

        assertEquals(r1, testRestaurantList.returnRandomRestaurant());
    }

    @Test
    void testReturnRandomRestaurantMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        Restaurant r = testRestaurantList.returnRandomRestaurant();
        int x = 0;

        while (x < 10) {
            assertTrue(r instanceof Restaurant);
            x++;
        }
    }

    @Test
    void testReturnRandomRestaurantCuisineOne() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setCuisine("vietnamese");
        r2.setCuisine("western");
        r3.setCuisine("chinese");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        assertEquals(r1, testRestaurantList.returnRandomRestaurantCuisine("vietnamese"));
    }

    @Test
    void testReturnRandomRestaurantCuisineMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setCuisine("chinese");
        r2.setCuisine("western");
        r3.setCuisine("chinese");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        Restaurant r = testRestaurantList.returnRandomRestaurantCuisine("chinese");
        int x = 0;

        while (x < 10) {
            assertTrue(r instanceof Restaurant);
            x++;
        }
    }

    @Test
    void testReturnRandomRestaurantLocationOne() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setLocation("vancouver");
        r2.setLocation("richmond");
        r3.setLocation("delta");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        assertEquals(r1, testRestaurantList.returnRandomRestaurantLocation("vancouver"));
    }

    @Test
    void testReturnRandomRestaurantLocationMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setLocation("vancouver");
        r2.setLocation("vancouver");
        r3.setLocation("delta");

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        Restaurant r = testRestaurantList.returnRandomRestaurantLocation("vancouver");
        int x = 0;

        while (x < 10) {
            assertTrue(r instanceof Restaurant);
            x++;
        }
    }


    @Test
    void testReturnRandomRestaurantPriceOne() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setPriceRange(1);
        r2.setPriceRange(2);
        r3.setPriceRange(1);

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        assertEquals(r2, testRestaurantList.returnRandomRestaurantPrice(2));
    }

    @Test
    void testReturnRandomRestaurantPriceMany() {
        Restaurant r1 = new Restaurant("Lotus");
        Restaurant r2 = new Restaurant("Cactus Club Cafe");
        Restaurant r3 = new Restaurant("Pearl Castle");
        r1.setPriceRange(1);
        r2.setPriceRange(2);
        r3.setPriceRange(1);

        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);

        Restaurant r = testRestaurantList.returnRandomRestaurantPrice(1);
        int x = 0;

        while (x < 10) {
            assertTrue(r instanceof Restaurant);
            x++;
        }
    }


}
