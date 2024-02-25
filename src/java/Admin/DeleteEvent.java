package Admin;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class DeleteEvent extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve event ID from request parameters
        int eventId = Integer.parseInt(request.getParameter("eventId"));

        // Call EventDAO method to delete the event
        EventDAO eventDAO = new EventDAO();
        boolean deleted = eventDAO.deleteEvent(eventId);

        if (deleted) {
            // Event successfully deleted, redirect to success page
            response.sendRedirect("eventDeleted.html");
        } else {
            // Error occurred while deleting event, redirect to error page
            response.sendRedirect("deleteEventError.jsp");
        }
    }
}
