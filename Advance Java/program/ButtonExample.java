import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ButtonExample extends JFrame implements ActionListener {
    private JButton chooseFileButton, selectColorButton;

    public ButtonExample() {
        super("Button Example");

        // Create the Choose File button
        chooseFileButton = new JButton("Choose File");
        chooseFileButton.setBounds(150, 150, 150, 30);
        chooseFileButton.addActionListener(this);
        add(chooseFileButton);

        // Create the Select Color button
        selectColorButton = new JButton("Choose Color");
        selectColorButton.setBounds(150, 200, 150, 30);
        selectColorButton.addActionListener(this);
        add(selectColorButton);

        // Set the window size and show the frame
        setSize(450, 300);
        setLocationRelativeTo(null); // Centers the window on the screen
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button events
        if (e.getSource() == chooseFileButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "You selected file: " + file.getName());
            }
        } else if (e.getSource() == selectColorButton) {
            Color color = JColorChooser.showDialog(this, "Select a Color", Color.BLACK);
            if (color != null) {
                JOptionPane.showMessageDialog(this, "You selected color: " + color.toString());
            }
        }
    }

    public static void main(String[] args) {
        ButtonExample btneg = new ButtonExample();
        btneg.setBounds(400, 400, 700, 600);
    }
}
