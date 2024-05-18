import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo extends JFrame {
    private JList<String> colorList;
    private JComboBox<String> countryComboBox;
    private JLabel selectedColorLabel;
    private JLabel selectedCountryLabel;

    private String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange"};
    private String[] countries = {"USA", "Canada", "UK", "Australia", "Japan"};

    public SwingDemo() {
        setTitle("Swing Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(3, 2));

        colorList = new JList<>(colors);
        countryComboBox = new JComboBox<>(countries);
        selectedColorLabel = new JLabel("Selected Color: ");
        selectedCountryLabel = new JLabel("Selected Country: ");

        colorList.addListSelectionListener(e -> updateSelectedColorLabel());
        countryComboBox.addActionListener(e -> updateSelectedCountryLabel());

        add(new JLabel("Select a Color:"));
        add(new JLabel("Select a Country:"));
        add(new JScrollPane(colorList));
        add(countryComboBox);
        add(selectedColorLabel);
        add(selectedCountryLabel);

        pack();
        setLocationRelativeTo(null);
    }

    private void updateSelectedColorLabel() {
        String selectedColor = colorList.getSelectedValue();
        if (selectedColor != null) {
            selectedColorLabel.setText("Selected Color: " + selectedColor);
        }
    }

    private void updateSelectedCountryLabel() {
        String selectedCountry = (String) countryComboBox.getSelectedItem();
        if (selectedCountry != null) {
            selectedCountryLabel.setText("Selected Country: " + selectedCountry);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingDemo demo = new SwingDemo();
            demo.setVisible(true);
        });
    }
}
