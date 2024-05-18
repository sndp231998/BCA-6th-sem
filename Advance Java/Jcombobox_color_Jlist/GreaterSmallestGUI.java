import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GreaterSmallestGUI extends JFrame {

    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JLabel outputLabel;
    private boolean isPressed;

    public GreaterSmallestGUI() {
        super("Greater and Smallest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);
        outputLabel = new JLabel("");
        outputLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel panel = new JPanel();
        panel.add(new Label("First Number:"));
        panel.add(firstNumberField);
        panel.add(new Label("Second Number:"));
        panel.add(secondNumberField);
        panel.add(outputLabel);

        getContentPane().add(panel);

        JButton button = new JButton("Find");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int firstNumber = Integer.parseInt(firstNumberField.getText());
                int secondNumber = Integer.parseInt(secondNumberField.getText());

                int greaterNumber = Math.max(firstNumber, secondNumber);
                int smallerNumber = Math.min(firstNumber, secondNumber);

                if (isPressed) {
                    outputLabel.setText(smallerNumber + " is the smaller number.");
                } else {
                    outputLabel.setText(greaterNumber + " is the greater number.");
                }

                isPressed = !isPressed;
            }
        });

        panel.add(button);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GreaterSmallestGUI();
    }
}
