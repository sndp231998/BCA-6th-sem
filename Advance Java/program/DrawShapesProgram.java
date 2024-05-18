import javax.swing.*;
import java.awt.*;

public class DrawShapesProgram extends JFrame {
    public DrawShapesProgram() {
        // Set up the JFrame
        setTitle("Draw Shapes Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw a rectangle
        g.setColor(Color.RED);
        g.fillRect(50, 50, 200, 100);

        // Draw an ellipse
        g.setColor(Color.BLUE);
        g.fillOval(150, 200, 150, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawShapesProgram::new);
    }
}
