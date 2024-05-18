import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SwingDemo  extends JFrame implements ActionListener{


    private JLabel nameLabel, gmailidLabel;
    private JTextField nameField, gmailidField;
    private JButton insertButton;


    public SwingDemo() {
        // Set up the frame
        setTitle("Swing Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Set up the content pane with GridBagLayout
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Set up the name label and field
        nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(nameLabel, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(nameField, gbc);

        // Set up the gmailid label and field
        gmailidLabel = new JLabel("Gmail ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(gmailidLabel, gbc);

        gmailidField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(gmailidField, gbc);

        // Set up the insert button
        insertButton = new JButton("Insert");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPane.add(insertButton, gbc);
        insertButton.addActionListener(this);

        // Pack and display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertButton) {
            // Get the data from the text fields
            String name = nameField.getText();
            String gmailid = gmailidField.getText();

            try {
                // Connect to the MySQL database
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdemo", "username", "password");

                // Insert the data into the table
                PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, gmailid) VALUES (?, ?)");
                ps.setString(1, name);
                ps.setString(2, gmailid);
                ps.executeUpdate();

                // Close the connection and reset the text fields
                conn.close();
                nameField.setText("");
                gmailidField.setText("");

                JOptionPane.showMessageDialog(null, "Data inserted successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo();
            }
        });
    }
}