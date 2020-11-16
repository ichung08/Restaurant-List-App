package ui;

import model.Restaurant;
import model.RestaurantList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
 */

public class RestaurantListGUI extends JFrame {
    protected RestaurantList restaurantList;
    protected JList<Restaurant> restaurantJList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/restaurantList.json";
    private JPanel restaurantListPanel;
    private JPanel buttonsPanel;
    private JButton addRestaurantButton;
    private JButton removeRestaurantButton;
    private JButton viewRestaurantButton;
    private JButton saveRestaurantButton;
    private JButton loadRestaurantButton;


    // EFFECTS: creates restaurantList GUI
    public RestaurantListGUI() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

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
        createViewRestaurantButton();
        createSaveRestaurantButton();
        createLoadRestaurantButton();

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        buttonsPanel.add(addRestaurantButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(removeRestaurantButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(viewRestaurantButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(saveRestaurantButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(loadRestaurantButton);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(buttonsPanel, BorderLayout.PAGE_END);
    }

    /*
    MODIFIES: this
    EFFECTS: creates addRestaurantButton and gives it an actionListener to open a new frame to add a restaurant
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
    EFFECTS: creates removeRestaurantButton and gives it an actionListener to remove restaurant
     */
    private void createRemoveRestaurantButton() {
        removeRestaurantButton = new JButton("Remove Restaurant");
        removeRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = restaurantJList.getSelectedIndex();
                restaurantList.removeRestaurant(i);

                if (restaurantList.length() == 0) {
                    removeRestaurantButton.setEnabled(false);
                } else {
                    if (i == restaurantList.length()) {
                        i--;
                    }

                    restaurantJList.setSelectedIndex(i);
                    restaurantJList.ensureIndexIsVisible(i);
                }
            }
        });
    }

    private void createViewRestaurantButton() {
        viewRestaurantButton = new JButton("View Restaurant");
        viewRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = restaurantJList.getSelectedIndex();

                new ViewRestaurantFrame(i);
            }

        });
    }
    


    private void createSaveRestaurantButton() {
        saveRestaurantButton = new JButton("Save");
        saveRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(restaurantList);
                    jsonWriter.close();
                    System.out.println("Saved" + restaurantList.getName() + " to " + JSON_STORE);
                } catch (FileNotFoundException e1) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
    }

    private void createLoadRestaurantButton() {
        loadRestaurantButton = new JButton("Load");
        loadRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    restaurantList = jsonReader.read();
                    System.out.println("Loaded " + restaurantList.getName() + " from " + JSON_STORE);
                } catch (IOException e1) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
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
        restaurantListPanel.setSize(200, 50);
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
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
