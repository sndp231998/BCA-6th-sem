/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mysqlcon;

/**
 *
 * @author mepra
 */
import java.sql.*;  
public class MysqlCon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
try{  
Class.forName("com.mysql.jdbc.Driver");  
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmc", "root", "")) {
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from user");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
    }  
}catch(ClassNotFoundException | SQLException e){ System.out.println(e);}  
}  } 

