import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Factorial extends JFrame implements ActionListener {
    private JLabel j1;
    private JTextField j2;
    private JButton b1;
 
    Factorial() {
        setTitle("Factorial Of Given Number");
        setLayout(null);

        j1 = new JLabel("Enter the number");
        j1.setBounds(50, 50, 100, 30);
        add(j1);

        j2 = new JTextField();
        j2.setBounds(160, 50, 100, 30);
        add(j2);

        b1 = new JButton("Factorial");
        b1.setBounds(100, 100, 100, 30);
        add(b1);

        b1.addActionListener(this);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(j2.getText());
        int factorial = 1;

        // Calculate factorial
        for (int i = num; i >= 1; i--) {
            factorial *= i;
        }

        // Display result
        JOptionPane.showMessageDialog(this, "Factorial of " + num + " is " + factorial);
    }

    public static void main(String[] args) {
        new Factorial();
    }
}
