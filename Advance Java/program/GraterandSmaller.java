import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class GraterandSmaller extends JFrame {
    private JTextField num1TextField, num2TextField, outputTextField;
    private JButton sumButton;
    
    public GraterandSmaller() {
        // Set window title
        setTitle("Grater and Smaller");
        
        // Set layout to null
        setLayout(null);
        
        // Create and add text fields
        num1TextField = new JTextField();
        num1TextField.setBounds(20, 20, 100, 20);
        add(num1TextField);
        
        num2TextField = new JTextField();
        num2TextField.setBounds(20, 50, 100, 20);
        add(num2TextField);
        

        
        outputTextField = new JTextField();
        outputTextField.setBounds(20, 80, 100, 20);
        outputTextField.setEditable(false);
        add(outputTextField);

        Font font = new Font("Arial", Font.BOLD, 18);
outputTextField.setFont(font);
        
        // Create and add button
        sumButton = new JButton("compare");
        sumButton.setBounds(20, 110, 100, 20);
        add(sumButton);
        
        // Add mouse listeners to button
        sumButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int num1 = Integer.parseInt(num1TextField.getText());
                int num2 = Integer.parseInt(num2TextField.getText());
               
                if(num1>num2){
                outputTextField.setText(String.valueOf(num1));
            }else{
            outputTextField.setText(String.valueOf(num2));
            }
        }
        
            public void mouseReleased(MouseEvent e) {
                int num1 = Integer.parseInt(num1TextField.getText());
                int num2 = Integer.parseInt(num2TextField.getText());
                if(num2>num1){
                    outputTextField.setText(String.valueOf(num1));
                }else{
                    outputTextField.setText(String.valueOf(num2));
                }
               
            }
        });
        
        // Set window size and visibility
        setSize(100, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        GraterandSmaller gui = new GraterandSmaller();
    }
}
