package ui;

import model.RestaurantList;

import javax.swing.*;
import java.awt.*;

public class ViewRestaurantFrame {
    protected RestaurantListGUI restaurantListGUI;
    protected JPanel viewPanel;
    private JLabel name;
    private JLabel address;
    private JLabel rating;
    private JLabel description;
    private JLabel cuisine;
    private JLabel location;
    private JLabel priceRange;

    // MODIFIES: this
    // EFFECTS: creates frame for view restaurant
    public ViewRestaurantFrame(int i, RestaurantListGUI restaurantListGUI) {
        JFrame frame = new JFrame("View Restaurant");

        this.restaurantListGUI = restaurantListGUI;

        viewPanel = new JPanel();
        viewPanel.setLayout(new GridLayout(7,1));
        initViewPanel(i);

        frame.add(viewPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /*
    MODIFIES: this
    EFFECTS: adds JLabels to view panel
     */
    private void initViewPanel(int i) {
        name = new JLabel("Viewing restaurant: " + restaurantListGUI.restaurantList.getRestaurant(i).getName());
        address = new JLabel("Address: " + restaurantListGUI.restaurantList.getRestaurant(i).getAddress());
        description = new JLabel("Description: "
                + restaurantListGUI.restaurantList.getRestaurant(i).getDescription());
        rating = new JLabel("Rating (out of 5): " + restaurantListGUI.restaurantList.getRestaurant(i).getRating());
        cuisine = new JLabel("Cuisine: " + restaurantListGUI.restaurantList.getRestaurant(i).getCuisine());
        location = new JLabel("Location: " + restaurantListGUI.restaurantList.getRestaurant(i).getLocation());
        priceRange = new JLabel("Price Range (1: $1 - $15, 2: $15 - $35, 3: $35 - $60, 4: $60+): "
                + restaurantListGUI.restaurantList.getRestaurant(i).getPriceRange());

        viewPanel.add(name);
        viewPanel.add(address);
        viewPanel.add(description);
        viewPanel.add(rating);
        viewPanel.add(cuisine);
        viewPanel.add(location);
        viewPanel.add(priceRange);
    }


}
