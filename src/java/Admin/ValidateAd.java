package Admin;


import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ValidateAd extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String un = request.getParameter("Ausername"); // Fetch username
        String pw = request.getParameter("Apassword"); // Fetch password
        response.setContentType("text/html");
        
        // Sets of Admin usernames & passwords
        String u1 = "A101";
        String p1 = "1234";
        String u2 = "A102";
        String p2 = "5678";
        String u3 = "A103";
        String p3 = "ABCD";
        String u4 = "A104";
        String p4 = "abcd";
        
        // Check credentials
        if (pw.equals(p1) && un.equals(u1)) {
            // Set session attribute for admin
            HttpSession session = request.getSession();
            session.setAttribute("adminUsername", un);
            // Forward to admin event page
            RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
            rd.forward(request, response);
        } else if (pw.equals(p2) && un.equals(u2)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminUsername", un);
            RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
            rd.forward(request, response);
        } else if (pw.equals(p3) && un.equals(u3)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminUsername", un);
            RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
            rd.forward(request, response);
        } else if (pw.equals(p4) && un.equals(u4)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminUsername", un);
            RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
            rd.forward(request, response);
        } else {
            // Credentials incorrect, stay on the login page
            out.println("<center><h1>!! Please Enter Valid Username & Password for Admin !!</h1><center>");
            RequestDispatcher rd = request.getRequestDispatcher("Alogin.html");
            rd.include(request, response);
        }
        out.close();
    }
}
