import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class CRUDForm extends JFrame {

    private JTextField tId, tName, tAge;
    private JButton insert, update, view, delete;

    public CRUDForm() {
        super("CRUD Form");
        setSize(500, 400);

        JPanel p = new JPanel(new java.awt.GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Set the insets for all components
        c.insets = new Insets(10, 10, 0, 10);
        
        
        JLabel Name = new JLabel("Name:");
        JLabel lLastName = new JLabel("Last Name:");
        
        tLastName = new JTextField(20);
        tName = new JTextField(20);

        insert = new JButton("Insert");

        c.gridx = 0; c.gridy = 0; p.add(Name, c);
        c.gridx = 1; c.gridy = 0; p.add(tName, c);
        c.gridx = 0; c.gridy = 1; p.add(lLastName, c);
        c.gridx = 1; c.gridy = 1; p.add(tLastName, c);
        
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2; p.add(insert, c);
      

       

       //c.insets = new Insets(10, 10, 10, 10);
        

        insert.addActionListener(e -> {
            String name = tName.getText();
            String lastName = tLastName.getText();

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/swingdemo", "root", "");
                 PreparedStatement pst = con.prepareStatement("INSERT INTO users (name, last_name) VALUES (?, ?)")) {
                pst.setString(1, name);
                pst.setString(2, lastName);
                pst.executeUpdate();
                System.out.println("Data inserted successfully.");
            } catch (SQLException ex) {
                System.err.println("Error inserting data: " + ex.getMessage());
            }
        });

        getContentPane().add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CRUDForm();
    }
}
