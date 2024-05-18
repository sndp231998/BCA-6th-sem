import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 * JlistExample
 */
public class JlistExample extends JFrame {
      JList li;
      public JlistExample(){
        String[] data={"ram","shyam","hari"};
        li=new JList(data);
        add(li);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> 
new JlistExample());
    }
}
