
package com.studentData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentOperation {
    
    public static boolean insertIntoDB(Student st){
        
        
        try{
        
            Connection con = JDBCConnection.generateCon();
            
            String q = "insert into students(sname, address, mobile, email, gender, course) values(?,?,?,?,?,?)";
            
            PreparedStatement pstmt =  con.prepareStatement(q);
            pstmt.setString(1, st.getSname());
            pstmt.setString(2, st.getAddress());
            pstmt.setString(3, st.getMobile() );
            pstmt.setString(4, st.getEmail());
            pstmt.setString(5, st.getGender());
            pstmt.setString(6, st.getCourse());
            
            pstmt.executeUpdate();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean DeleteFromDB(int sId){
        
        try{
        
            Connection con = JDBCConnection.generateCon();
            
            String q = "delete from students where sId=?";
            
            PreparedStatement pstmt =  con.prepareStatement(q);
            pstmt.setInt(1, sId);
            
            pstmt.executeUpdate();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("empty-statement")
    public static ResultSet ShowDetails(int sId) {
        
        try{
        
            Connection con = JDBCConnection.generateCon();
            
            String q = "select * from students where sId=?";
            
            PreparedStatement pstmt =  con.prepareStatement(q);
            pstmt.setInt(1, sId);   
            return pstmt.executeQuery();
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
