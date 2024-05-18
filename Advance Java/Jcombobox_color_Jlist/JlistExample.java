import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 * JlistExample
 */
public class JlistExample extends JFrame {
    JList<String> li; 
    JComboBox<String> combo;// Specify the generic type here
    public JlistExample() {
        setSize(300, 200);
        String[] data = { "ram", "shyam", "hari" };
        String[] data1 = { "ram", "shyam", "hari" };
        li = new JList<>(data);
       li.setBounds(20,20,10,10);
        combo=new JComboBox<>(data1);
        combo.setBounds(40,50,10,10);
        add(li);
        add(combo);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JlistExample());
    }
}
