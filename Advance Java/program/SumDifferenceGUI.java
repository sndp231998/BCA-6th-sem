import javax.swing.*;
import java.awt.event.*;

public class SumDifferenceGUI extends JFrame {
    private JTextField num1TextField, num2TextField, outputTextField;
    private JButton sumButton;
    
    public SumDifferenceGUI() {
        // Set window title
        setTitle("Sum and Difference GUI");
        
        // Set layout to null
        setLayout(null);
        
        // Create and add text fields
        num1TextField = new JTextField();
        num1TextField.setBounds(20, 20, 100, 20);
        add(num1TextField);

        JTextField mn=new JTextField();
        mn.setBounds(120,20,50,20);
        add(mn);

        num2TextField = new JTextField();
        num2TextField.setBounds(20, 50, 100, 20);
        add(num2TextField);
        
        outputTextField = new JTextField();
        outputTextField.setBounds(20, 80, 100, 20);
        outputTextField.setEditable(false);
        add(outputTextField);
        
        // Create and add button
        sumButton = new JButton("Sum");
        sumButton.setBounds(20, 110, 100, 20);
        add(sumButton);
        
        // Add mouse listeners to button
        sumButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int num1 = Integer.parseInt(num1TextField.getText());
                int num2 = Integer.parseInt(num2TextField.getText());
                int sum = num1 + num2;
                outputTextField.setText(String.valueOf(sum));
            }
            
            public void mouseReleased(MouseEvent e) {
                int num1 = Integer.parseInt(num1TextField.getText());
                int num2 = Integer.parseInt(num2TextField.getText());
                int difference = num1 - num2;
                outputTextField.setText(String.valueOf(difference));
            }
        });
        
        // Set window size and visibility
        setSize(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        SumDifferenceGUI gui = new SumDifferenceGUI();
    }
}
