import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FactorialAndFibonacciGUI extends JFrame {
    JTextField num1;
    JLabel output;
    JButton calculate;

    public FactorialAndFibonacciGUI() {
        setTitle("Magic calculator");
        setSize(200, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        num1 = new JTextField();
        num1.setBounds(20, 20, 50, 20);
        add(num1);

        output = new JLabel("");
        output.setBounds(20, 50, 100, 20); // Increase width to display the full Fibonacci series
        add(output);

        calculate = new JButton("Calculate");
        calculate.setBounds(20, 80, 100, 20); // Increase width to fit the button text
        add(calculate);

        calculate.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                factorial();
            }

            public void mouseReleased(MouseEvent e) {
                fibonacci();
            }
        });
    }

    public void factorial() {
        int a = Integer.parseInt(num1.getText());
        int fact = 1;
        for (int i = 2; i <= a; i++) {
            fact = fact * i;
        }
        output.setText("Factorial: " + fact); // Show the result in the label
    }

    public void fibonacci() {
        int a = Integer.parseInt(num1.getText());
        int first = 0;
        int sec = 1;
        int fibon = 0;
        String fibSeries = "Fibonacci Series: ";
        
        for (int i = 0; i < a; i++) {
            if (i <= 1) {
                fibon = i;
            } else {
                fibon = first + sec;
                first = sec;
                sec = fibon;
            }
            fibSeries += fibon + " ";
        }
        output.setText(fibSeries); // Show the Fibonacci series in the label
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FactorialAndFibonacciGUI());
    }
}
