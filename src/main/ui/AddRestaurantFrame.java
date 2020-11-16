package ui;

import model.Restaurant;
import ui.RestaurantListGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.security.acl.Group;

// https://stackoverflow.com/questions/15513380/how-to-open-a-new-window-by-clicking-a-button
public class AddRestaurantFrame {
    private JFrame frame;
    private JPanel panel;
    private JPanel labelPanel;
    private JButton addRestaurant;
    private JButton cancel;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField ratingField;
    private JTextField descriptionField;
    private JTextField cuisineField;
    private JTextField locationField;
    private JTextField priceRangeField;
    private JLabel name;
    private JLabel address;
    private JLabel rating;
    private JLabel description;
    private JLabel cuisine;
    private JLabel location;
    private JLabel priceRange;
    RestaurantListGUI restaurantListGUI = new RestaurantListGUI();


    // MODIFIES: this
    // EFFECTS: creates new add restaurant window
    public AddRestaurantFrame() {
        frame = new JFrame("Add Restaurant");

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(true);

        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(8,2));
        initFields();
        initLabels();
        initButtons();
        addListener();
        cancelListener();
        addToLabelPanel();

        panel.add(labelPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /*
    MODIFIES: this
    EFFECTS: initializes labels
     */
    private void initLabels() {
        name = new JLabel("Name: ");
        name.setHorizontalAlignment(JLabel.RIGHT);
        address = new JLabel("Address: ");
        address.setHorizontalAlignment(JLabel.RIGHT);
        rating = new JLabel("Rating (1 - 5): ");
        rating.setHorizontalAlignment(JLabel.RIGHT);
        description = new JLabel("Description: ");
        description.setHorizontalAlignment(JLabel.RIGHT);
        cuisine = new JLabel("Cuisine: ");
        cuisine.setHorizontalAlignment(JLabel.RIGHT);
        location = new JLabel("Location: ");
        location.setHorizontalAlignment(JLabel.RIGHT);
        priceRange = new JLabel("Price Range (1 - 4): ");
        priceRange.setHorizontalAlignment(JLabel.RIGHT);
    }

    /*
    MODIFIES: this
    EFFECTS: initializes JTextFields
     */
    private void initFields() {
        nameField = new JTextField(5);
        addressField = new JTextField(5);
        ratingField = new JTextField(5);
        descriptionField = new JTextField(5);
        cuisineField = new JTextField(5);
        locationField = new JTextField(5);
        priceRangeField = new JTextField(5);
    }

    /*
    MODIFIES: this
    EFFECTS: initializes JButtons
     */
    private void initButtons() {
        addRestaurant = new JButton("Add");
        cancel = new JButton("Cancel");
    }

    /*
    MODIFIES: this
    EFFECTS: creates add button action listener
     */
    private void addListener() {
        addRestaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurant r = new Restaurant(nameField.getText());
                r.setAddress(addressField.getText());
                r.setRating(Integer.parseInt(ratingField.getText()));
                r.setDescription(descriptionField.getText());
                r.setCuisine(cuisineField.getText());
                r.setLocation(locationField.getText());
                r.setPriceRange(Integer.parseInt(priceRangeField.getText()));

                restaurantListGUI.restaurantList.addRestaurant(r);

                nameField.setText("");
                addressField.setText("");
                ratingField.setText("");
                descriptionField.setText("");
                cuisineField.setText("");
                locationField.setText("");
                priceRangeField.setText("");
            }
        });
    }

    /*
    MODIFIES: this
    EFFECTS: creates cancel button action listener
     */
    private void cancelListener() {
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }


    /*
    MODIFIES: this
    EFFECTS: adds labels, fields and buttons to labelPanel
     */
    private void addToLabelPanel() {
        labelPanel.add(name);
        labelPanel.add(nameField);
        labelPanel.add(address);
        labelPanel.add(addressField);
        labelPanel.add(rating);
        labelPanel.add(ratingField);
        labelPanel.add(description);
        labelPanel.add(descriptionField);
        labelPanel.add(cuisine);
        labelPanel.add(cuisineField);
        labelPanel.add(location);
        labelPanel.add(locationField);
        labelPanel.add(priceRange);
        labelPanel.add(priceRangeField);
        labelPanel.add(addRestaurant);
        labelPanel.add(cancel);
    }
}