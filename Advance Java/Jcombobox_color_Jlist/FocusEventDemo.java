import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusEventDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Focus Event Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);

        // Add a FocusListener to the first text field
        textField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField1.setBackground(Color.YELLOW);
                textField2.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField1.setBackground(Color.WHITE);
            }
        });

        // Add a FocusListener to the second text field
        textField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField2.setBackground(Color.YELLOW);
                textField1.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField2.setBackground(Color.WHITE);
            }
        });

        frame.add(textField1);
        frame.add(textField2);

        frame.setVisible(true);
    }
}
