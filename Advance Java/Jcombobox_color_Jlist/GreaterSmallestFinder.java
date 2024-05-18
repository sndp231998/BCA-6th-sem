import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GreaterSmallestFinder extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JLabel outputLabel;

    public GreaterSmallestFinder() {
        setTitle("Greater and Smallest Finder");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and configure components
        JPanel panel = new JPanel();
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        outputLabel = new JLabel();
        outputLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Add key listeners to text fields
        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                findGreaterOrSmallest();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                findGreaterOrSmallest();
            }
        });

        textField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                findGreaterOrSmallest();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                findGreaterOrSmallest();
            }
        });

        // Add components to the panel
        panel.add(new JLabel("Enter number 1:"));
        panel.add(textField1);
        panel.add(new JLabel("Enter number 2:"));
        panel.add(textField2);
        panel.add(outputLabel);

        // Add the panel to the frame
        add(panel);

        // Display the frame
        setVisible(true);
    }

    private void findGreaterOrSmallest() {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            if (num1 > num2) {
                outputLabel.setText("Greater: " + num1);
            } else {
                outputLabel.setText("Smallest: " + num2);
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
            outputLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GreaterSmallestFinder();
        });
    }
}
