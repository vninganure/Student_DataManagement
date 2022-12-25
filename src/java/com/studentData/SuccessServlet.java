
package com.studentData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class SuccessServlet extends HttpServlet{
    
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html");
        
        PrintWriter out = res.getWriter();
        
        out.println("Successfully Registered");
        out.println("<h2>Welcome to the Scaler</h2>");
    }
    
}
