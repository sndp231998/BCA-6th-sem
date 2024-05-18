import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageChooser extends JFrame implements ActionListener {

    private JButton chooseBtn, saveBtn;
    private JLabel imageLbl;
    private JFileChooser fileChooser;

    public ImageChooser() {
        setTitle("Image Chooser");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chooseBtn = new JButton("Choose Image");
        chooseBtn.addActionListener(this);
        chooseBtn.setBounds(50, 50, 150, 30);

        saveBtn = new JButton("Save Image");
        saveBtn.addActionListener(this);
        saveBtn.setBounds(200, 50, 150, 30);
        saveBtn.setEnabled(false);

        imageLbl = new JLabel();
        imageLbl.setHorizontalAlignment(JLabel.CENTER);

        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        add(chooseBtn);
        add(saveBtn);
        add(imageLbl, BorderLayout.CENTER);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
                imageLbl.setIcon(imageIcon);
                saveBtn.setEnabled(true);
            }
        } else if (e.getSource() == saveBtn) {
            ImageIcon imageIcon = (ImageIcon) imageLbl.getIcon();
            Image image = imageIcon.getImage();
            JFileChooser saveFileChooser = new JFileChooser();
            saveFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int saveResult = saveFileChooser.showSaveDialog(this);
            if (saveResult == JFileChooser.APPROVE_OPTION) {
                File saveFile = saveFileChooser.getSelectedFile();
                // TODO: Save image to file
            }
        }
    }

    public static void main(String[] args) {
        ImageChooser imageChooser = new ImageChooser();
        imageChooser.setVisible(true);
    }
}
