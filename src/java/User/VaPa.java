package User;

import java.io.IOException;  
import java.io.PrintWriter;  
import jakarta.servlet.RequestDispatcher;  
import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  
import jakarta.servlet.http.HttpSession; // Import HttpSession class
  
public class VaPa extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        //Fetching data  from HTML form
        String n = request.getParameter("Pausername");  
        String p = request.getParameter("Papassword");  
        
        // Validate username and password
        if(LoginDao.validate(n, p)){  
            // Create a session
            HttpSession session = request.getSession();
            // Set session attribute to store username
            session.setAttribute("username", n);
            
            // Forward user to ParticipantEvent.html
            RequestDispatcher rd = request.getRequestDispatcher("ParticipantEvent.jsp");  
            rd.forward(request, response);  
        }  
        else{  
            out.print("<center><h1>Sorry username and password incorrect</h1></center>");  
            RequestDispatcher rd = request.getRequestDispatcher("Plogin.html");  
            rd.include(request, response);  
        }  
        out.close();  
    }  
}  
