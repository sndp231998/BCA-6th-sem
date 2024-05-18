import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {
    public GridLayoutExample() {
        super("GridLayout Example");

        // Set the layout of the JFrame to GridLayout with 0 rows and 3 columns
        setLayout(new GridLayout(0, 5));

        // Add some components to the JFrame
        for (int i = 1; i <= 9; i++) {
            add(new JButton("Button " + i));
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridLayoutExample());
    }
}
