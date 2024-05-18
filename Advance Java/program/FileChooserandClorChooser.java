import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileChooserandClorChooser extends JFrame implements ActionListener {
    
    private JButton fileButton, colorButton;
    private JLabel fileLabel, colorLabel;
    private JFileChooser fileChooser;
    private JColorChooser colorChooser;
    
    public FileChooserandClorChooser() {
        super("Swing Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fileButton = new JButton("Choose File");
        fileButton.addActionListener(this);
        fileButton.setBounds(20, 20, 120, 30);
        
        colorButton = new JButton("Choose Color");
        colorButton.addActionListener(this);
        colorButton.setBounds(20, 60, 120, 30);
        
        fileLabel = new JLabel();
        fileLabel.setBounds(160, 20, 120, 30);
        
        colorLabel = new JLabel();
        colorLabel.setOpaque(true);
        colorLabel.setBounds(160, 60, 120, 30);
        
        add(fileButton);
        add(colorButton);
        add(fileLabel);
        add(colorLabel);
        setLayout(null);
        
        setVisible(true);
        
        fileChooser = new JFileChooser();
        colorChooser = new JColorChooser();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileButton) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                fileLabel.setText(file.getName());
            }
        } else if (e.getSource() == colorButton) {
            Color color = JColorChooser.showDialog(this, "Choose a Color", Color.WHITE);
            colorLabel.setBackground(color);
        }
    }
    
    public static void main(String[] args) {
        FileChooserandClorChooser example = new FileChooserandClorChooser();
    }
}
