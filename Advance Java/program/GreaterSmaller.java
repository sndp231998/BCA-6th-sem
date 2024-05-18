import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreaterSmaller extends JFrame implements KeyListener {
    private JTextField txtNum1, txtNum2;
    private JLabel lblResult;

    public GreaterSmaller() {
        super("Find Greater and Smaller");
        setBounds(100, 100, 500, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JLabel lblNum1 = new JLabel("First number:");
        lblNum1.setBounds(10, 10, 100, 25);
        panel.add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(120, 10, getWidth() / 2 - 20, 25);
        txtNum1.addKeyListener(this);
        panel.add(txtNum1);

        JLabel lblNum2 = new JLabel("Second number:");
        lblNum2.setBounds(getWidth() / 2 + 10, 10, 100, 25);
        panel.add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(getWidth() / 2 + 120, 10, getWidth() / 2 - 20, 25);
        txtNum2.addKeyListener(this);
        panel.add(txtNum2);

        JLabel lblResultText = new JLabel("Result:");
        lblResultText.setBounds(10, 40, 50, 25);
        panel.add(lblResultText);

        lblResult = new JLabel();
        lblResult.setFont(new Font("Arial", Font.BOLD, 18));
        lblResult.setBounds(70, 40, getWidth() - 90, 25);
        panel.add(lblResult);

        add(panel);
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            int num1 = Integer.parseInt(txtNum1.getText());
            int num2 = Integer.parseInt(txtNum2.getText());
            int greater = Math.max(num1, num2);
            lblResult.setText(Integer.toString(greater));
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            int num1 = Integer.parseInt(txtNum1.getText());
            int num2 = Integer.parseInt(txtNum2.getText());
            int smaller = Math.min(num1, num2);
            lblResult.setText(Integer.toString(smaller));
        }
    }

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new GreaterSmaller();
    }
}
