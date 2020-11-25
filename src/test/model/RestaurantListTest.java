package model;

import exceptions.NonZeroLengthException;
import exceptions.PriceRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantListTest {
    private RestaurantList testRestaurantList;
    private Restaurant r1;
    private Restaurant r2;
    private Restaurant r3;

    @BeforeEach
    void runBefore() {
        testRestaurantList = new RestaurantList("My Restaurant List");
        try {
            r1 = new Restaurant("Lotus");
            r2 = new Restaurant("Cactus Club Cafe");
            r3 = new Restaurant("Pearl Castle");
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testConstructor() {
        assertEquals(0, testRestaurantList.length());
        assertEquals("My Restaurant List", testRestaurantList.getName());
    }

    @Test
    void testAddRestaurant() {
        testRestaurantList.addRestaurant(r1);
        assertEquals(1, testRestaurantList.length());
    }

    @Test
    void testRemoveRestaurantOne() {
        testRestaurantList.addRestaurant(r1);
        testRestaurantList.removeRestaurant(0);

        assertEquals(0, testRestaurantList.length());
    }

    @Test
    void testRemoveRestaurantMany() {
        testRestaurantList.addRestaurant(r1);
        testRestaurantList.addRestaurant(r2);
        testRestaurantList.addRestaurant(r3);
        testRestaurantList.removeRestaurant(1);

        assertEquals(2, testRestaurantList.length());
    }

    @Test
    void testGetRestaurantOne() {
        testRestaurantList.addRestaurant(r1);
        assertEquals(r1, testRestaurantList.getRestaurant(0));
    }

    @Test
    void testGetRestaurantMany() {
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
        try {
            r1.setCuisine("vietnamese");
            r2.setCuisine("western");
            r3.setCuisine("chinese");
            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList Japanese = testRestaurantList.sortRestaurantCuisine("japanese");
            assertEquals(0, Japanese.length());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSortRestaurantCuisineOne() {
        try {
            r3.setCuisine("chinese");
            r1.setCuisine("vietnamese");
            r2.setCuisine("western");
            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList Chinese = testRestaurantList.sortRestaurantCuisine("chinese");
            assertEquals(1, Chinese.length());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSortRestaurantCuisineMany() {
        try {
            r1.setCuisine("chinese");
            r2.setCuisine("western");
            r3.setCuisine("chinese");

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList Chinese = testRestaurantList.sortRestaurantCuisine("chinese");
            assertEquals(2, Chinese.length());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSortRestaurantLocationNone() {
        try {
            r1.setLocation("vancouver");
            r2.setLocation("richmond");
            r3.setLocation("delta");

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList Surrey = testRestaurantList.sortRestaurantLocation("surrey");
            assertEquals(0, Surrey.length());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSortRestaurantLocationOne() {
        try {
            r1.setLocation("vancouver");
            r2.setLocation("richmond");
            r3.setLocation("delta");

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList Richmond = testRestaurantList.sortRestaurantLocation("richmond");
            assertEquals(1, Richmond.length());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSortRestaurantLocationMany() {
        try {
            r1.setLocation("vancouver");
            r2.setLocation("richmond");
            r3.setLocation("richmond");

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList Richmond = testRestaurantList.sortRestaurantLocation("richmond");
            assertEquals(2, Richmond.length());
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSortRestaurantPriceNone() {
        try {
            r1.setPriceRange(1);
            r2.setPriceRange(2);
            r3.setPriceRange(1);

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList $ = testRestaurantList.sortRestaurantPrice(3);
            assertEquals(0, $.length());
        } catch (PriceRangeException e) {
            fail("Exception should not have been caught");
        }


    }

    @Test
    void testSortRestaurantPriceOne() {
        try {
            r1.setPriceRange(1);
            r2.setPriceRange(2);
            r3.setPriceRange(1);

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList $ = testRestaurantList.sortRestaurantPrice(2);
            assertEquals(1, $.length());
        } catch (PriceRangeException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testSortRestaurantPriceMany() {
        try {
            r1.setPriceRange(1);
            r2.setPriceRange(2);
            r3.setPriceRange(1);

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            RestaurantList $ = testRestaurantList.sortRestaurantPrice(1);
            assertEquals(2, $.length());
        } catch (PriceRangeException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testReturnRandomRestaurantOne() {
        testRestaurantList.addRestaurant(r1);

        assertEquals(r1, testRestaurantList.returnRandomRestaurant());
    }

    @Test
    void testReturnRandomRestaurantMany() {
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
        try {
            r1.setCuisine("vietnamese");
            r2.setCuisine("western");
            r3.setCuisine("chinese");

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            assertEquals(r1, testRestaurantList.returnRandomRestaurantCuisine("vietnamese"));
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testReturnRandomRestaurantCuisineMany() {
        try {
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
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testReturnRandomRestaurantLocationOne() {
        try {
            r1.setLocation("vancouver");
            r2.setLocation("richmond");
            r3.setLocation("delta");

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            assertEquals(r1, testRestaurantList.returnRandomRestaurantLocation("vancouver"));
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testReturnRandomRestaurantLocationMany() {
        try {
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
        } catch (NonZeroLengthException e) {
            fail("Exception should not have been caught");
        }
    }


    @Test
    void testReturnRandomRestaurantPriceOne() {
        try {
            r1.setPriceRange(1);
            r2.setPriceRange(2);
            r3.setPriceRange(1);

            testRestaurantList.addRestaurant(r1);
            testRestaurantList.addRestaurant(r2);
            testRestaurantList.addRestaurant(r3);

            assertEquals(r2, testRestaurantList.returnRandomRestaurantPrice(2));
        } catch (PriceRangeException e) {
            fail("Exception should not have been caught");
        }
    }

    @Test
    void testReturnRandomRestaurantPriceMany() {
        try {
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
        } catch (PriceRangeException e) {
            fail("Exception should not have been caught");
        }
    }
}
