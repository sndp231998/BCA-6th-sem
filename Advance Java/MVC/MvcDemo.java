import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

// Model
class BookModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// View
class BookView extends JFrame {
    private JTextField nameField = new JTextField(20);
    private JButton addButton = new JButton("Add Book");

    public BookView() {
        setTitle("Book Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name: "));
        panel.add(nameField);
        panel.add(addButton);

        add(panel);
        pack();
    }

    public String getNameInput() {
        return nameField.getText();
    }

    public void addButtonListener(ActionListener listener) {
    addButton.addActionListener(listener);
}

    }


// Controller
class BookController {
    private BookModel model;
    private BookView view;

   public BookController(BookModel model, BookView view) {
    this.model = model;
    this.view = view;

    view.addButtonListener(new AddButtonListener());
}


    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();

            model.setName(name);

            if (saveToDatabase(name)) {
                JOptionPane.showMessageDialog(null, "Book added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error adding book.");
            }
        }
    }

    private boolean saveToDatabase(String name) {
        // Connection conn = null;
        // PreparedStatement pstmt = null;
        // boolean success = false;

         try {
        // Load the JDBC driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish the connection to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/book?user=root&password=231998");
        Statement stmt = conn.createStatement();
        
        String insertSQL = "INSERT INTO books (name) VALUES ('" + name + "')";
        int rowaffect = stmt.executeUpdate(insertSQL);

        while(rowaffect> 0){
            System.out.println("Success full insert");
    }
} catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
        return false;
    }

}

// Main class
public class MvcDemo {
    public static void main(String[] args) {
        BookModel model = new BookModel();
        BookView view = new BookView();
        BookController controller = new BookController(model, view);

        view.setVisible(true);
    }
}
