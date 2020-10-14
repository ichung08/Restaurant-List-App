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
        switch (command) {
            case "a":
                doAdd();
                break;
            case "r":
                doRemove();
                break;
            case "v":
                doView();
                break;
            case "sc":
                doSortCuisine();
                break;
//            case "sl":
//                doSortLocation();
//            case "sp":
//                doSortPrice();
            default:
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
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds a restaurant to myRestaurantList
    private void doAdd() {
        System.out.println("Make a restaurant to add: ");
        String name = input.next();
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


    private void doSortCuisine() {
        System.out.println("Enter a cuisine to sort restaurants by: ");
        String cuisine = input.next();
        RestaurantList cuisineList = myRestaurantList.sortRestaurantCuisine(cuisine);

        printRestaurants(cuisineList);
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
        restaurant.setRating(rating);
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
        restaurant.setPriceRange(priceRange);
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








