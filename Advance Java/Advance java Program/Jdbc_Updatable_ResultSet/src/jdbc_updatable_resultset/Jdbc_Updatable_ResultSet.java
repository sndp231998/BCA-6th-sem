/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc_updatable_resultset;

/**
 *
 * @author mepradip
 */
import java.sql.*;
public class Jdbc_Updatable_ResultSet {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp", "root", "")) {
            System.out.println("Connection established......");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from employee");
            while(rs.next()) {
         System.out.print("ID: " + rs.getInt("id"));
         System.out.print(", Name: " + rs.getString("name"));
         System.out.print(", Address: " + rs.getString("address"));
         System.out.println();
            }
          System.out.println("\n------------------------------------------------------");
            rs.first();
            rs.updateInt(1, 1);
            rs.updateRow();
            System.out.println("1 ROW UPDATED...");
            rs.moveToInsertRow();
            rs.updateInt(1, 5);
            rs.updateString(2, "Anmol");
            rs.updateString(3, "Damak");
            rs.insertRow();
            System.out.println("1 ROW INSERTED...");
            System.out.println("After Updation...");
            
           rs.beforeFirst();
          System.out.println("\n------------------------------------------------------");
            while(rs.next()) {
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", Address: " + rs.getString("address"));
            System.out.println();
            }
        }
    }

}