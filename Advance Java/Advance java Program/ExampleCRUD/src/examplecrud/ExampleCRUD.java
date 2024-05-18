/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examplecrud;

/**
 *
 * @author mepra
 */
import java.sql.*;
public class ExampleCRUD {

public static void main(String[] args) throws SQLException, ClassNotFoundException {
Class.forName("com.mysql.jdbc.Driver");  
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dmc", "root", "");  
System.out.println("Successfully connected");
    //insert user record into database
    Statement stmt = conn.createStatement();
    int rows = stmt.executeUpdate("INSERT INTO user(name, username, email) VALUES ('Harry','me.harry','harry@gmail.com')");
    System.out.println("Rows inserted = "+ rows);
//update user record
    rows= stmt.executeUpdate("Update user set username='me.pradip' where Id=2;");
    System.out.println("Rows updated = "+ rows);
    //read user records
    ResultSet rs = stmt.executeQuery("Select * from user");
    while(rs.next()){
      System.out.println("Id : " + rs.getInt("Id") + ", Name : " + rs.getString("name") + ", Username : " + rs.getString("username") + ", Email : " + rs.getString("email"));
    }
    //delete  record
   // rows = stmt.executeUpdate("delete from user where Id = 1");
    //System.out.println("Rows deleted = "+ rows);
  }
}
