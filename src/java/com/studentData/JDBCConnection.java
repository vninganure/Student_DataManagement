
package com.studentData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
   static Connection con;
   
   public static Connection generateCon() throws ClassNotFoundException{
       try{
           //Load the driver..
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           //create connection 
           String user = "root";
           String password = "Vijay@1998";
           String url = "jdbc:mysql://localhost:3306/student_management";
           
           con = DriverManager.getConnection(url, user, password);
       }
       catch(ClassNotFoundException | SQLException e){
           e.printStackTrace();
       }
       
       return con;
       
   }
}
