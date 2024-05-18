import java.sql.*;

public class JdbcSelect {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/bca";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(CONNECTION_URL, "root", "231998");
          
            Statement stmt = con.createStatement();

            String insertSql = "INSERT INTO students VALUES(3,'santa',9)";
            int rowsAffected = stmt.executeUpdate(insertSql);

            System.out.println(rowsAffected + " row(s) inserted successfully");

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " Name: " + rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
