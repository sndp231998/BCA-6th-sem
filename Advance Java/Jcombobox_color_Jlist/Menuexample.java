import javax.swing.*;

public class Menuexample {
    JMenuBar MB;
    JMenu m1, m2, m3, subMenu;
    JMenuItem i1, i2;
    JFrame frame = new JFrame();

    public Menuexample() {
        frame.setVisible(true);
        frame.setTitle("Demo menu");

        MB = new JMenuBar();

        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");
        
        subMenu = new JMenu("Submenu"); // Creating a submenu
        
        i1 = new JMenuItem("Save");
        i2 = new JMenuItem("Save As");
       

        m1.add(i1);
        m1.add(i2);
        
        subMenu.add(i1); // Adding items to the submenu
        subMenu.add(i2);
      

        m1.add(subMenu); // Adding the submenu to m

        MB.add(m1);
        MB.add(m2);
        MB.add(m3);

        frame.setJMenuBar(MB);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menuexample());
    }
}
