package User;

import Admin.EventDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class RegisterEvent extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve event ID and title from request parameters
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        String eventName = request.getParameter("eventName");

        // Retrieve user information from session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            // User is not logged in, redirect to login page
            response.sendRedirect("login.jsp");
            return;
        }

        // Call EventDAO method to register user for the event
        EventDAO eventDAO = new EventDAO();
        boolean success = eventDAO.registerUserForEvent(username, eventId);

        if (success) {
            out.println("<h1><b>Registration Successful!</b></h1>");
            out.println("<p><i>You have successfully registered for the event: " + eventName + "</i></p>");
        } else {
            out.println("<h1><b>Registration Failed!</b></h1>");
            out.println("<p><i>Sorry, unable to register for the event at the moment.</i></p>");
        }
    }
}
