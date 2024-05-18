/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudapp;

/**
 *
 * @author mepra
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CRUDApp extends JFrame implements ActionListener {
    // database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dmc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "231998";

    // GUI components
    private JButton addButton, updateButton, readButton, deleteButton;
    private JTextField idField, nameField, ageField;
    private JTextArea outputArea;

    // database connection and statement objects
    private Connection conn;
    private Statement stmt;

    public CRUDApp() throws ClassNotFoundException {
        // initialize GUI components
        idField = new JTextField(10);
        nameField = new JTextField(10);
        ageField = new JTextField(10);

        addButton = new JButton("Insert");
        addButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);

        readButton = new JButton("View");
        readButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(readButton);
        buttonPanel.add(deleteButton);

        JPanel outputPanel = new JPanel();
        outputPanel.add(new JScrollPane(outputArea));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        // initialize database connection and statement objects
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database: " + e.getMessage());
            System.exit(1);
        }

        // initialize JFrame
        setTitle("CRUD App");
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addRecord();
        } else if (e.getSource() == updateButton) {
            updateRecord();
        } else if (e.getSource() == readButton) {
            readRecords();
        } else if (e.getSource() == deleteButton) {
            deleteRecord();
        }
    }

    private void addRecord() {
        String id = idField.getText();
        String name = nameField.getText();
        String age = ageField.getText();

        try {
            String sql = "INSERT INTO info VALUES (" + id + ", '" + name + "', " + age + ")";
            stmt.executeUpdate(sql);
            outputArea.setText("Record added: " + id + ", " + name + ", " + age + "\n");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to add record: " + e.getMessage());
        }
    }

    private void updateRecord() {
        String id = idField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
    try {
        String sql = "UPDATE info SET name='" + name + "', age=" + age + " WHERE id=" + id;
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected == 0) {
            outputArea.setText("Record not found: " + id + "\n");
        } else {
            outputArea.setText("Record updated: " + id + ", " + name + ", " + age + "\n");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to update record: " + e.getMessage());
    }
}

private void readRecords() {
    try {
        String sql = "SELECT * FROM info";
        ResultSet rs = stmt.executeQuery(sql);

        StringBuilder sb = new StringBuilder();
        sb.append("ID\tName\tAge\n");
        sb.append("--------------------------------------------\n");
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String age = rs.getString("age");
            sb.append(id + "\t" + name + "\t" + age + "\n");
        }
        outputArea.setText(sb.toString());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to read records: " + e.getMessage());
    }
}

private void deleteRecord() {
    String id = idField.getText();

    try {
        String sql = "DELETE FROM info WHERE id=" + id;
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected == 0) {
            outputArea.setText("Record not found: " + id + "\n");
        } else {
            outputArea.setText("Record deleted: " + id + "\n");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to delete record: " + e.getMessage());
    }
}
public static void main(String[] args) throws ClassNotFoundException {
    new CRUDApp();
}
}
