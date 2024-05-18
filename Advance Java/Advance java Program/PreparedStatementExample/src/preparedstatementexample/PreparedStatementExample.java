/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package preparedstatementexample;

/**
 *
 * @author mepra
 */
import java.sql.*;
public class PreparedStatementExample {
   public static void main(String args[]) throws SQLException, ClassNotFoundException {
      //Registering the Driver
     Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dmc", "root", "");
      System.out.println("Connection established......");

      //Creating a Prepared Statement
      String query = "INSERT INTO user(name, username, email) VALUES (?, ?, ?)";
      PreparedStatement pstmt = con.prepareStatement(query);

      pstmt.setString(1, "Arpan");
      pstmt.setString(2, "Arpan_don");
      pstmt.setString(3, "Arpan@gmail.com");
      pstmt.executeUpdate();
      pstmt.setString(1, "Aryan");
      pstmt.setString(2, "Aryan_hero");
      pstmt.setString(3, "Aryan@gmail.com");

      pstmt.executeUpdate();
      System.out.println("Rows inserted " );
   }
}
