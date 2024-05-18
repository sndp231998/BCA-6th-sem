import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JListJComboBoxDemo {

    private JFrame frame;
    private JList<String> list;
    private JComboBox<String> comboBox;
    private JLabel label;

    public JListJComboBoxDemo() {
        frame = new JFrame("JList JComboBox Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        list = new JList<>(new String[]{"Red", "Green", "Blue", "Yellow", "Orange", "Purple"});
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        comboBox = new JComboBox<>(new String[]{"India", "USA", "China", "Japan", "Brazil", "Russia"});

        label = new JLabel("Selected Color/Country: ");

        JPanel panel = new JPanel();
        panel.add(list);
        panel.add(comboBox);
        panel.add(label);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String color = list.getSelectedValue();
                label.setText("Selected Color: " + color);
            }
        });

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String country = (String) comboBox.getSelectedItem();
                label.setText("Selected Country: " + country);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JListJComboBoxDemo();
        });
    }
}
