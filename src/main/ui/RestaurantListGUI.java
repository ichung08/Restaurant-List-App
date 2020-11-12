package ui;

import model.Restaurant;
import model.RestaurantList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantListGUI extends JFrame {
    private RestaurantList restaurantList;
    private JList<Restaurant> restaurantJList;
    private JPanel restaurantListPanel;
    private JPanel buttonsPanel;
    private JButton addRestaurantButton;
    private JButton removeRestaurantButton;

    public RestaurantListGUI() {
        createRestaurantList();
        createRestaurantJList();
        createRestaurantListPanel();
        addButtonsPanel();
        createGui();
    }

    /*
    MODIFIES: this
    EFFECTS: adds buttons to buttonsPanel
     */
    private void addButtonsPanel() {
        createAddRestaurantButton();
        createRemoveRestaurantButton();

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        buttonsPanel.add(addRestaurantButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(Box.createVerticalStrut(1));
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(removeRestaurantButton);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(buttonsPanel, BorderLayout.PAGE_END);
    }

    /*
    MODIFIES: this
    EFFECTS: creates addRestaurantButton
     */
    private void createAddRestaurantButton() {
        addRestaurantButton = new JButton("Add Restaurant");
        addRestaurantButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddRestaurantFrame();
            }
        });
    }

    /*
    MODIFIES: this
    EFFECTS: creates removeRestaurantButton
     */
    private void createRemoveRestaurantButton() {
        removeRestaurantButton = new JButton("Remove Restaurant");
        removeRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /*
    MODIFIES: this
    EFFECTS: creates restaurantListPanel and adds JList and JScrollPane
     */
    private void createRestaurantListPanel() {
        restaurantListPanel = new JPanel();
        restaurantListPanel.add(restaurantJList);
        restaurantListPanel.add(new JScrollPane(restaurantJList));
        add(restaurantListPanel, BorderLayout.CENTER);
    }

    /*
    MODIFIES: this
    EFFECTS: creates JList using restaurantList
     */
    private void createRestaurantJList() {
        restaurantJList = new JList<Restaurant>(restaurantList.getRestaurantList());
        restaurantJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        restaurantJList.setSelectedIndex(0);
        restaurantJList.setVisibleRowCount(5);
    }

    /*
    MODIFIES: this
    EFFECTS: creates a new restaurantList
     */
    private void createRestaurantList() {
        restaurantList = new RestaurantList("My Restaurant List");
        Restaurant r1 = new Restaurant("McDonald's");
        restaurantList.addRestaurant(r1);
        restaurantList.addRestaurant(r1);
        restaurantList.addRestaurant(r1);
        restaurantList.addRestaurant(r1);
        restaurantList.addRestaurant(r1);
        restaurantList.addRestaurant(r1);
    }

    /*
    EFFECTS: sets up and creates GUI for display
     */
    private void createGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Restaurant List GUI");
        this.pack();
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
