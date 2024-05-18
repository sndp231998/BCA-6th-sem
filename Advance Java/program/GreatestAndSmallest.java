import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreatestAndSmallest extends JFrame implements KeyListener {

    private JTextField textField1, textField2;
    private JLabel label;
    private int num1, num2;

    public GreatestAndSmallest() {
        super("Greatest and Smallest");

        // Create text fields
        textField1 = new JTextField(10);
        textField1.setBounds(20, 20, 100, 20);
        textField1.addKeyListener(this);

        textField2 = new JTextField(10);
        textField2.setBounds(20, 50, 100, 20);
        textField2.addKeyListener(this);

        // Create label
        label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(20, 80, 300, 20);

        // Add components to the frame
        add(textField1);
        add(textField2);
        add(label);

        // Set frame properties
        setSize(350, 150);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // KeyListener methods
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            num1 = Integer.parseInt(textField1.getText());
            num2 = Integer.parseInt(textField2.getText());
            label.setText("Greater number: " + Math.max(num1, num2));
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            num1 = Integer.parseInt(textField1.getText());
            num2 = Integer.parseInt(textField2.getText());
            label.setText("Smaller number: " + Math.min(num1, num2));
        }
    }

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new GreatestAndSmallest();
    }
}
