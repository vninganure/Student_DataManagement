
package com.studentData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
//        out.println("Congratulations, Successfully registered");
        String name = request.getParameter("user_name");
        String address = request.getParameter("user_address");
        String mobile = request.getParameter("user_mobile");
        String email = request.getParameter("user_email");
        String course = request.getParameter("user_course");
        
        String cond = request.getParameter("condition");
        
        if(cond!=null){
            if(cond.equals("checked")){
                out.println("<h2>name: "+name+"</h2>");
                out.println("<h2>address: "+address+"</h2>");
                out.println("<h2>mobile: "+mobile+"</h2>");
                out.println("<h2>email: "+email+"</h2>");
                out.println("<h2>course: "+course+"</h2>");
                
                //
                //JDBC
                //
                
                // success servlet
                
                RequestDispatcher rd = request.getRequestDispatcher("success");
                rd.forward(request, response);
                

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
}
