import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreatestSmallestGUI extends JFrame {
    private JTextField num1TextField, num2TextField;
    private JLabel resultLabel;
    
    public GreatestSmallestGUI() {
        // Set window title
        setTitle("Greatest and Smallest GUI");
        
        // Set layout to FlowLayout
        setLayout(new FlowLayout());
        
        // Create and add text fields
        num1TextField = new JTextField(10);
        add(new JLabel("Number 1:"));
        add(num1TextField);
        
        num2TextField = new JTextField(10);
        add(new JLabel("Number 2:"));
        add(num2TextField);
        
        // Create and add label
        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(resultLabel);
        
        // Add key listeners to text fields
        num1TextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                updateResult();
            }
            
            public void keyReleased(KeyEvent e) {
                updateResult();
            }
        });
        
        num2TextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                updateResult();
            }
            
            public void keyReleased(KeyEvent e) {
                updateResult();
            }
        });
        
        // Set window size and visibility
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void updateResult() {
        int num1 = Integer.parseInt(num1TextField.getText());
        int num2 = Integer.parseInt(num2TextField.getText());
        
        if (num1 > num2) {
            resultLabel.setText("Greater: " + num1);
        } else {
            resultLabel.setText("Smaller: " + num1);
        }
    }
    
    public static void main(String[] args) {
        GreatestSmallestGUI gui = new GreatestSmallestGUI();
    }
}
