import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileAndColorChooserExample extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JColorChooser colorChooser;

    public FileAndColorChooserExample() {
        super("File and Color Choosers Example");

        // Create the text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create the File menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create the Open menu item
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        // Create the Color menu
        JMenu colorMenu = new JMenu("Color");
        menuBar.add(colorMenu);

        // Create the Choose menu item
        JMenuItem chooseMenuItem = new JMenuItem("Choose");
        chooseMenuItem.addActionListener(this);
        colorMenu.add(chooseMenuItem);

        // Create the file chooser
        fileChooser = new JFileChooser();

        // Create the color chooser
        colorChooser = new JColorChooser();

        // Set the window size and show the frame
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle menu item events
        if (e.getActionCommand().equals("Open")) {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("Choose")) {
            Color color = JColorChooser.showDialog(this, "Choose a Color", Color.BLACK);
            if (color != null) {
                textArea.setForeground(color);
            }
        }
    }

    public static void main(String[] args) {
        new FileAndColorChooserExample();
    }
}
