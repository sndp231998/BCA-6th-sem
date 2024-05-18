import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusEventExample extends JFrame implements FocusListener {

    private JTextField textField1;
    private JTextField textField2;

    public FocusEventExample() {
        setTitle("Focus Event Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textField1 = new JTextField("Text Field 1");
        textField2 = new JTextField("Text Field 2");

        textField1.addFocusListener(this);
        textField2.addFocusListener(this);

        JPanel panel = new JPanel();
        panel.add(textField1);
        panel.add(textField2);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FocusEventExample());
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == textField1) {
            System.out.println("Focus Gained on Text Field 1");
        } else if (e.getSource() == textField2) {
            System.out.println("Focus Gained on Text Field 2");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == textField1) {
            System.out.println("Focus Lost on Text Field 1");
        } else if (e.getSource() == textField2) {
            System.out.println("Focus Lost on Text Field 2");
        }
    }
}
