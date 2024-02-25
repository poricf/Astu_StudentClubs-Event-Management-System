package Admin;

import java.io.*;
import java.sql.Timestamp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import Admin.EventDAO;

public class UpdateEvent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve edited event details from request parameters
        String eventIdParam = request.getParameter("eventId");
        String durationParam = request.getParameter("duration");
        
        // Check if eventId and duration parameters are not empty
        if (eventIdParam == null || eventIdParam.isEmpty() || durationParam == null || durationParam.isEmpty()) {
            // Handle case where eventId or duration is missing or empty
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Event ID or duration is missing.");
            return;
        }

        // Parse parameters to integers
        int eventId = Integer.parseInt(eventIdParam);
        int duration = Integer.parseInt(durationParam);

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dateTimeString = request.getParameter("dateTime");
        
        Timestamp dateTime = null;
        

        String location = request.getParameter("location");
        String organizer = request.getParameter("organizer");

        // Call EventDAO method to edit the event
        EventDAO eventDAO = new EventDAO();
        boolean edited = eventDAO.editEvent(eventId, title, description, dateTime, location, duration, organizer);

        if (edited) {
            // Event successfully edited, redirect to success page
            response.sendRedirect("eventEdited.jsp");
        } else {
            // Error occurred while editing event, redirect to error page
            response.sendRedirect("editEventError.jsp");
        }
    }
}
