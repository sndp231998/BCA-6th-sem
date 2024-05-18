import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ImageUploader extends JFrame implements ActionListener {
   private JButton chooseButton, displayButton;
   private JLabel imageLabel;
   private ImageIcon image;

   public ImageUploader() {
      setTitle("Image Uploader");
      setSize(400, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      chooseButton = new JButton("Choose");
      displayButton = new JButton("Display");
      imageLabel = new JLabel();

      chooseButton.setBounds(50, 50, 100, 30);
      displayButton.setBounds(200, 50, 100, 30);
      imageLabel.setBounds(50, 100, 300, 250);

      chooseButton.addActionListener(this);
      displayButton.addActionListener(this);

      add(chooseButton);
      add(displayButton);
      add(imageLabel);

      setLayout(null);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == chooseButton) {
         JFileChooser fileChooser = new JFileChooser();
         int result = fileChooser.showOpenDialog(this);
         if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            image = new ImageIcon(selectedFile.getAbsolutePath());
         }
      } else if (e.getSource() == displayButton) {
         if (image != null) {
            imageLabel.setIcon(image);
         }
      }
   }

   public static void main(String[] args) {
      new ImageUploader();
   }
}
