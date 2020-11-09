package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantListGUI implements ActionListener {
    private JPanel panel;
    private JFrame frame;
    private JButton button;
    private JLabel label;

    public RestaurantListGUI() {
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Add restaurant");
        label = new JLabel("List of Restaurants");
        createPanel();
        createFrame();
        createButton();

    }

    private void createFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Restaurant List");
        frame.pack();
        frame.setVisible(true);
    }

    private void createPanel() {
        Border border = BorderFactory.createEmptyBorder(100, 100, 100, 200);
        panel.setBorder(border);

        GridLayout gridLayout = new GridLayout(0, 1);
        panel.setLayout(gridLayout);

        panel.add(button);
        panel.add(label);
    }

    private void createButton() {
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
