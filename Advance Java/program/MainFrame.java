import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener {

    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JLabel resultLabel;

    public MainFrame() {
        setTitle("Find Greatest and Smallest Numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel firstNumberLabel = new JLabel("First number:");
        firstNumberField = new JTextField();
        firstNumberField.setPreferredSize(new Dimension(50, 25));
        firstNumberField.addKeyListener(this);

        JLabel secondNumberLabel = new JLabel("Second number:");
        secondNumberField = new JTextField();
        secondNumberField.setPreferredSize(new Dimension(50, 25));
        secondNumberField.addKeyListener(this);

        JLabel resultTextLabel = new JLabel("Result:");
        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(firstNumberLabel);
        panel.add(firstNumberField);
        panel.add(secondNumberLabel);
        panel.add(secondNumberField);
        panel.add(resultTextLabel);
        panel.add(resultLabel);

        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            int firstNumber = Integer.parseInt(firstNumberField.getText());
            int secondNumber = Integer.parseInt(secondNumberField.getText());
            int result = Math.max(firstNumber, secondNumber);
            resultLabel.setText(Integer.toString(result));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            int firstNumber = Integer.parseInt(firstNumberField.getText());
            int secondNumber = Integer.parseInt(secondNumberField.getText());
            int result = Math.min(firstNumber, secondNumber);
            resultLabel.setText(Integer.toString(result));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
