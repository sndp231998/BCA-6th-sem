import javax.swing.*;

public class Dilog {
    JDialog d;
    JLabel lbl;
    JTextField txt;

    public Dilog() {
        JFrame f = new JFrame();
        f.setTitle("Dialog");
       f.setSize(400, 300); 
        f.setVisible(true);

        lbl = new JLabel("Email");
        txt = new JTextField(10);

        d = new JDialog(f, "This is dialog", true); // Pass the parent JFrame 'f'
        d.getContentPane().add(lbl); // Add components to the contentPane of the dialog
        d.getContentPane().add(txt);

        d.pack(); // Pack the dialog to fit its components
        d.setVisible(true); // Show the dialog
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dilog());
    }
}
