import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ImageDisplayWithFileDialog {
    private JFrame frame;
    private JLabel imageLabel;

    public ImageDisplayWithFileDialog() {
        frame = new JFrame("Image Display with FileDialog");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        imageLabel = new JLabel();
        frame.add(imageLabel, BorderLayout.CENTER);

        JButton uploadButton = new JButton("Upload");
       
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(uploadButton);
        
        frame.add(buttonPanel, BorderLayout.SOUTH);

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadImage();
            }
        });

    }

    private void uploadImage() {
        FileDialog fileDialog = new FileDialog(frame, "Choose an image", FileDialog.LOAD);
        fileDialog.setVisible(true);

        String filename = fileDialog.getFile();
        if (filename != null) {
            String imagePath = fileDialog.getDirectory() + filename;
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        }
    }

 

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageDisplayWithFileDialog app = new ImageDisplayWithFileDialog();
            app.show();
        });
    }
}
