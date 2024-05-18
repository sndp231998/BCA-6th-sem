import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;
import java.awt.Font;
import java.sql.*;

public class GridBagLayout {
    public static void main(String[] args) {
        new RegistrationForm();
    }
}

class RegistrationForm extends JFrame {

    JLabel reg, name, email, phone, gender;
    JTextField tName, tEmail, tphone;
    JRadioButton male, female;
    //male select garya paxi female pn select
    // hunxa so tesko lagi yo ButtonGroup
    ButtonGroup gb;
    JButton signup;
    JPanel p_reg, p;

    public RegistrationForm() {
        super();
        setTitle("Registration Form");
        setSize(500, 400);

        Font f1 = new Font("TimesRoman", Font.BOLD, 18);
        Font f2 = new Font("TimesRoman", Font.BOLD, 15);

        reg = new JLabel("Registration Form");
        reg.setFont(f1);
        name = new JLabel("Name");
        name.setFont(f2);
        email = new JLabel("Email");
        email.setFont(f2);
        phone = new JLabel("Phone No");
        phone.setFont(f2);
        gender = new JLabel("Gender");
        gender.setFont(f2);

        tName = new JTextField(15);
        tEmail = new JTextField(15);
        tphone = new JTextField(15);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        gb = new ButtonGroup();
        gb.add(male);
        gb.add(female);

        signup = new JButton("signup");
        signup.setFont(f2);
        p = new JPanel();
        p.add(male);
        p.add(female);

        p_reg = new JPanel(new java.awt.GridBagLayout()); // fixed here
        GridBagConstraints c1 = new GridBagConstraints();

        c1.insets = new Insets(10, 0, 0, 0);
        c1.anchor = GridBagConstraints.LINE_START;
        c1.gridx = 0; c1.gridy = 0; p_reg.add(reg, c1);
        c1.gridx = 0;c1.gridy = 1;  p_reg.add(name, c1);
        c1.gridx = 1;c1.gridy = 1;  p_reg.add(tName, c1);
        c1.gridx = 0; c1.gridy = 2; p_reg.add(email, c1);
        c1.gridx = 1;c1.gridy = 2;  p_reg.add(tEmail, c1);
        c1.gridx = 0;c1.gridy = 3;  p_reg.add(phone, c1);
        c1.gridx = 1; c1.gridy = 3; p_reg.add(tphone, c1);
        c1.gridx = 0; c1.gridy = 4; p_reg.add(gender, c1);
        c1.gridx = 1; c1.gridy = 4; p_reg.add(p, c1);
        c1.gridx = 1; c1.gridy = 5; p_reg.add(signup, c1);

        p_reg.setBackground(java.awt.Color.CYAN);
        p.setBackground(java.awt.Color.CYAN);
        signup.setBackground(java.awt.Color.PINK);
        reg.setForeground(java.awt.Color.red);

        this.getContentPane().add(p_reg);

        // Add action listener to signup button
        signup.addActionListener(e -> {
            // Get form data
            String name = tName.getText();
            String email = tEmail.getText();
            String phone = tphone.getText();
            String gender = male.isSelected() ? "Male" : "Female";
        
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/swingdemo";
            String username = "root";
            String password = "";
        
            try {
                // Connect to the database
                Connection conn = DriverManager.getConnection(url, username, password);
        
                // Create a prepared statement to insert the form data into the database
                String sql = "INSERT INTO registration (name, email, phone, gender) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, phone);
                statement.setString(4, gender);
        
                // Execute the statement
                int rowsInserted = statement.executeUpdate();
        
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Registration Successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Failed");
                }
        
                // Close the connection and statement
                statement.close();
                conn.close();
        
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            }
        });
    
        
