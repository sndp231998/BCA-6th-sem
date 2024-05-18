import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageDisplayer {

    private JFrame frame;
    private BufferedImage image;
    private JButton button;

    public ImageDisplayer() {
        frame = new JFrame("Image Displayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Upload");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

                // Show the file chooser
                int result = fileChooser.showOpenDialog(frame);

                // If the user selects a file
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File file = fileChooser.getSelectedFile();

                    // Load the image
                    try {
                        image = ImageIO.read(file);
                    } catch (IOException e1) {
                        System.err.println("Error loading image: " + e1.getMessage());
                    }

                    // Create a label to display the image
                    JLabel label = new JLabel(new ImageIcon(image));

                    // Add the label to the frame
                    frame.add(label);
                    frame.pack();
                }
            }
        });

        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ImageDisplayer();
    }
}
