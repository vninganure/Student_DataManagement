
package com.studentData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String action = request.getParameter("action");
        
        if(action.equals("register")){
            String name = request.getParameter("user_name");
            String address = request.getParameter("user_address");
            String mobile = request.getParameter("user_mobile");
            String email = request.getParameter("user_email");
            String course = request.getParameter("user_course");
            String gender = request.getParameter("user_gender");

            String cond = request.getParameter("condition");

            if(cond!=null){
                if(cond.equals("checked")){
                    


                    //JDBC


                    Student st = new Student(name, address, mobile,email, gender, course);
                    boolean is_successful = StudentOperation.insertIntoDB(st);

                    if(is_successful){
                        out.println("<h2>Your details successfully added to DB</h2>");
                        // success servlet
                        RequestDispatcher rd = request.getRequestDispatcher("success");
                        rd.include(request, response);
                    }
                    else{
                        out.println("<h2>something went wrong, please try again...</h2>");
                    }
                }
                else{
                    out.println("<h2> Please accept the terms and conditons</h2>");
                }
            }
            else{
                out.println("<h2 style='color: red;'> *Please accept the terms and conditons</h2>");

                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }
        }
        else if(action.equals("delete")){
            String sId = request.getParameter("student_id");
            String password = request.getParameter("admin_password");
            
            if(password.equals("admin")){
                boolean is_successful = StudentOperation.DeleteFromDB(Integer.parseInt(sId));
                
                if(is_successful){
                    out.println("<h2>Your details successfully deleted from DB</h2>");
                    // success servlet
//                    RequestDispatcher rd = request.getRequestDispatcher("success");
//                    rd.include(request, response);
                }
                else{
                    out.println("<h2>something went wrong, please try again...</h2>");
                }
            }
            else{
                out.println("<h2 style='color: red;'> *Please put correct password</h2>");

                RequestDispatcher rd = request.getRequestDispatcher("deleteStudent.html");
                rd.include(request, response);
            }
            
        }
        
        else if(action.equals("show_details")){
            String sId = request.getParameter("student_id");
            try{
                
                ResultSet set = StudentOperation.ShowDetails(Integer.parseInt(sId));
                
                
                if(set.next()==true){
//                    
                    out.println("<h2>student ID: "+sId+"</h2>");
                    String name = set.getString("sname");
                    String address = set.getString("address");
                    String mobile = set.getString("mobile");
                    String email = set.getString("email");
                    String gender = set.getString("gender");
                    String course = set.getString("course");

                    out.println("<h2>name: "+name+"</h2>");
                    out.println("<h2>address: "+address+"</h2>");
                    out.println("<h2>mobile: "+mobile+"</h2>");
                    out.println("<h2>email: "+email+"</h2>");
                    out.println("<h2>course: "+course+"</h2>");
                    out.println("<h2>course: "+gender+"</h2>");

                }
                else{
                    out.println("<h2 style='color: red;'> *Please enter valid student Id</h2>");

                    RequestDispatcher rd = request.getRequestDispatcher("ShowDetails.html");
                    rd.include(request, response);
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
            
    }
}
