package ui;

import model.Restaurant;
import model.RestaurantList;

import java.util.Scanner;

// Restaurant List application
public class RestaurantListApp {
    private RestaurantList myRestaurantList;
    private Scanner input;

    // EFFECTS: runs the restaurant list application
    public RestaurantListApp() {
        runRestaurantList();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runRestaurantList() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }

        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAdd();
        } else if (command.equals("r")) {
            doRemove();
        } else if (command.equals("v")) {
            doView();
        } else if (command.equals("sc")) {
            doSortCuisine();
        } else if (command.equals("sl")) {
            doSortLocation();
        } else if (command.equals("sp")) {
            doSortPrice();
        } else if (command.equals("rand")) {
            doRandomRestaurant();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    // MODIFIES: this
    // EFFECTS: initializes restaurant list
    private void init() {
        myRestaurantList = new RestaurantList();
        Restaurant r1 = new Restaurant("McDonald's");
        r1.setAddress("1234 Number 5 Rd. Richmond, British Columbia");
        r1.setDescription("World famous burger and fries!");
        r1.setRating(5);
        r1.setLocation("richmond");
        r1.setPriceRange(1);
        r1.setCuisine("fast food");
        myRestaurantList.addRestaurant(r1);
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a restaurant");
        System.out.println("\tr -> remove a restaurant");
        System.out.println("\tv -> view a restaurant");
        System.out.println("\tsc -> sort by cuisine");
        System.out.println("\tsl -> sort by location");
        System.out.println("\tsp -> sort by price");
        System.out.println("\trand -> random restaurant");
        System.out.println("--------------------------------");
        System.out.println("\tq -> quit");
        System.out.println("--------------------------------");
    }

    // MODIFIES: this
    // EFFECTS: adds a restaurant to myRestaurantList
    private void doAdd() {
        System.out.println("Make a restaurant to add: ");
        input.nextLine();
        String name = input.nextLine();
        Restaurant restaurant = new Restaurant(name);

        doAddAddress(restaurant);
        doAddDescription(restaurant);
        doAddRating(restaurant);
        doAddCuisine(restaurant);
        doAddLocation(restaurant);
        doAddPrice(restaurant);

        myRestaurantList.addRestaurant(restaurant);
        printRestaurants(myRestaurantList);
    }

    // MODIFIES: this
    // EFFECTS: removes a restaurant from myRestaurantList
    private void doRemove() {
        System.out.println("Choose a restaurant to remove: ");
        printRestaurants(myRestaurantList);
        int num = input.nextInt();
        myRestaurantList.removeRestaurant(num - 1);

        printRestaurants(myRestaurantList);
    }

    // MODIFIES: this
    // EFFECTS: views a specific restaurant from myRestaurantList
    private void doView() {
        System.out.println("Choose a restaurant to view: ");
        printRestaurants(myRestaurantList);
        int num = input.nextInt();
        Restaurant r = myRestaurantList.getRestaurant(num - 1);

        System.out.println("Viewing restaurant " + r.getName());
        System.out.println("Address: " + r.getAddress());
        System.out.println("Description: " + r.getDescription());
        System.out.println("Rating (out of 5): " + r.getRating() + " star");
        System.out.println("Cuisine: " + r.getCuisine());
        System.out.println("Location: " + r.getLocation());
        System.out.println("Price Range (1: $1 - $15, 2: $15 - $35, 3: $35 - $60,"
                + " 4: $60+): " + r.getPriceRange());

    }

    // MODIFIES: this
    // EFFECTS: sorts myRestaurantList by a specific cuisine and returns those restaurants
    private void doSortCuisine() {
        System.out.println("Enter a cuisine to sort restaurants by: ");
        input.nextLine();
        String cuisine = input.nextLine();
        RestaurantList cuisineList = myRestaurantList.sortRestaurantCuisine(cuisine);

        printRestaurants(cuisineList);
    }

    // MODIFIES: this
    // EFFECTS: sorts myRestaurantList by a specific location and returns those restaurants
    private void doSortLocation() {
        System.out.println("Enter a location to sort restaurants by: ");
        input.nextLine();
        String location = input.nextLine();
        RestaurantList locationList = myRestaurantList.sortRestaurantLocation(location);

        printRestaurants(locationList);
    }

    // MODIFIES: this
    // EFFECTS: sorts myRestaurantList by a specific price range and returns those restaurants
    private void doSortPrice() {
        System.out.println("Enter a price range to sort restaurants by: ");
        int priceRange = input.nextInt();

        if (priceRange < 1 || priceRange > 5) {
            System.out.println("Enter a price range between 1 - 4!");
            priceRange = input.nextInt();
            RestaurantList priceList = myRestaurantList.sortRestaurantPrice(priceRange);
            printRestaurants(priceList);

        } else {
            RestaurantList priceList = myRestaurantList.sortRestaurantPrice(priceRange);
            printRestaurants(priceList);
        }

    }

    // MODIFIES: this
    // EFFECTS: returns a random restaurant in myRestaurantList
    private void doRandomRestaurant() {
        System.out.println("Searching for a random restaurant...");
        Restaurant r = myRestaurantList.returnRandomRestaurant();

        System.out.println("Viewing restaurant " + r.getName());
        System.out.println("Address: " + r.getAddress());
        System.out.println("Description: " + r.getDescription());
        System.out.println("Rating (out of 5): " + r.getRating() + " star");
        System.out.println("Cuisine: " + r.getCuisine());
        System.out.println("Location: " + r.getLocation());
        System.out.println("Price Range (1: $1 - $15, 2: $15 - $35, 3: $35 - $60,"
                + " 4: $60+): " + r.getPriceRange());
    }

    // MODIFIES: this
    // EFFECTS: adds an address to a restaurant
    protected void doAddAddress(Restaurant restaurant) {
        System.out.println("Add an address to your restaurant: ");
        input.nextLine();
        String address = input.nextLine();
        restaurant.setAddress(address);
    }

    // MODIFIES: this
    // EFFECTS: adds a description to a restaurant
    private void doAddDescription(Restaurant restaurant) {
        System.out.println("Add a description to your restaurant: ");
        input.nextLine();
        String description = input.nextLine();
        restaurant.setDescription(description);
    }

    // MODIFIES: this
    // EFFECTS: adds a rating to a restaurant
    private void doAddRating(Restaurant restaurant) {
        System.out.println("Add a rating to your restaurant (1, 2, 3, 4, or 5): ");
        int rating = input.nextInt();

        if (rating < 1 || rating > 5) {
            System.out.println("Enter a rating between 1 - 5!");
            rating = input.nextInt();
            restaurant.setRating(rating);
        } else {
            restaurant.setRating(rating);
        }

    }

    // MODIFIES: this
    // EFFECTS: adds a cuisine tag to a restaurant
    private void doAddCuisine(Restaurant restaurant) {
        System.out.println("Add a cuisine tag to your restaurant: ");
        input.nextLine();
        String cuisine = input.next();
        restaurant.setCuisine(cuisine);
    }

    // MODIFIES: this
    // EFFECTS: adds a location to a restaurant
    private void doAddLocation(Restaurant restaurant) {
        System.out.println("Add a location tag to your restaurant: ");
        input.nextLine();
        String location = input.next();
        restaurant.setLocation(location);
    }

    // MODIFIES: this
    // EFFECTS: adds a price range to a restaurant
    private void doAddPrice(Restaurant restaurant) {
        System.out.println("Add a price range tag to your restaurant (1: $1 - $15, 2: $15 - $35, 3: $35 - $60,"
                + " 4: $60+): ");
        int priceRange = input.nextInt();

        if (priceRange < 1 || priceRange > 4) {
            System.out.println("Enter a price range between 1 - 4!");
            priceRange = input.nextInt();
            restaurant.setPriceRange(priceRange);

        } else {
            restaurant.setPriceRange(priceRange);
        }

    }

    // EFFECTS: returns all restaurants in myRestaurantList
    private void printRestaurants(RestaurantList restaurantList) {
        System.out.println("Restaurant List: ");

        for (int count = 0; count < restaurantList.length(); count++) {
            Restaurant restaurant = restaurantList.getRestaurant(count);
            int num = count + 1;
            System.out.println(num + ". " + restaurant.getName());
        }
    }
}








