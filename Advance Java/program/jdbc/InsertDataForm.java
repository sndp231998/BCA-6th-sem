import java.awt.*;
import java.sql.*;
import javax.swing.*;


public class InsertDataForm extends JFrame {

    private JTextField tName, tLastName,tid;
    private JButton insert,updatebtn,deletebtn,viewbtn;
    private JTextArea outputArea;

    public InsertDataForm() {
        super("Insert Data Form");
        setSize(500, 400);

        JPanel p = new JPanel(new java.awt.GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Set the insets for all components
        c.insets = new Insets(10, 10, 0, 10);
        
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        
        JLabel lid=new JLabel("ID");
        JLabel Name = new JLabel("Name:");
        JLabel lLastName = new JLabel("Last Name:");
        
        tLastName = new JTextField(20);
        tName = new JTextField(20);
        tid=new JTextField(20);

        insert = new JButton("Insert");
        updatebtn = new JButton("Update");
        deletebtn = new JButton("Delete");
        viewbtn = new JButton("Display");

        c.gridx = 0; c.gridy = 0; p.add(lid, c);
        c.gridx = 1; c.gridy = 0; p.add(tid, c);
        c.gridx = 0; c.gridy = 1; p.add(Name, c);
        c.gridx = 1; c.gridy = 1; p.add(tName, c);
        c.gridx = 0; c.gridy = 2; p.add(lLastName, c);
        c.gridx = 1; c.gridy = 2; p.add(tLastName, c);
        
        
       //c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0; c.gridy = 3; p.add(insert, c);
        c.gridx = 1; c.gridy = 3; p.add(updatebtn, c);
        c.gridx = 0; c.gridy = 4; p.add(viewbtn, c);
        c.gridx = 1; c.gridy = 4; p.add(deletebtn, c);
        c.gridx=0; c.gridy=5; p.add(outputArea,c);

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
        new InsertDataForm();
    }
}
