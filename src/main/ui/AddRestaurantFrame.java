package ui;

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
        addToLabelPanel();

        panel.add(labelPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Restaurant List GUI");
        frame.pack();
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

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

    private void initFields() {
        nameField = new JTextField(5);
        addressField = new JTextField(5);
        ratingField = new JTextField(5);
        descriptionField = new JTextField(5);
        cuisineField = new JTextField(5);
        locationField = new JTextField(5);
        priceRangeField = new JTextField(5);
    }

    private void initButtons() {
        addRestaurant = new JButton("Add");
        addRestaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

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