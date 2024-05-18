import javax.swing.*;
import java.awt.*;

public class LayoutManagerProgram extends JFrame {
    private JButton button1, button2, button3, button4, button5;

    public LayoutManagerProgram() {
        // Set up the JFrame
        setTitle("Layout Manager Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");

        // Create panels
        JPanel flowPanel = new JPanel(new FlowLayout());
        JPanel gridPanel = new JPanel(new GridLayout(2, 2));
        JPanel borderPanel = new JPanel(new BorderLayout());
        JPanel boxPanel = new JPanel();

        // Set layout for boxPanel
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);

        // Add buttons to panels
        flowPanel.add(button1);
        flowPanel.add(button2);
        gridPanel.add(button3);
        gridPanel.add(button4);
        borderPanel.add(button5, BorderLayout.CENTER);

        // Add panels to the JFrame
        add(flowPanel);
        add(gridPanel);
        add(borderPanel);
        add(boxPanel);

        // Set JFrame properties
        setLayout(new FlowLayout());
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LayoutManagerProgram::new);
    }
}
