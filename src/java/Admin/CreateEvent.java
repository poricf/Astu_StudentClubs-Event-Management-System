import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class CreateEvent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Check if admin is logged in
        HttpSession session = request.getSession(false); // Do not create a new session if one does not exist
        String adminUsername = (String) session.getAttribute("adminUsername");
        if (adminUsername == null) {
            // Admin is not logged in, redirect to login page
            response.sendRedirect("Alogin.html");
            return;
        }
        
        String dateTime = request.getParameter("dateTime");
        String location = request.getParameter("location");

        if (isEventDuplicate(dateTime, location)) {
            request.setAttribute("errorMessage", "Event at the same date and time already exists at this location!");
            RequestDispatcher rd = request.getRequestDispatcher("CreateE.jsp");
            rd.forward(request, response);
        } else {
            // Proceed with event registration
            if (registerEvent(request)) {
                response.sendRedirect("successPage.jsp");
            } else {
                request.setAttribute("errorMessage", "Failed to register event. Please try again later.");
                RequestDispatcher rd = request.getRequestDispatcher("CreateE.jsp");
                rd.forward(request, response);
            }
        }
        
        out.close();
    }
    
    private boolean isEventDuplicate(String dateTime, String location) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/ASTU_StudentUnionDB";
            String user = "root";
            String pass = "Fahmi@12345";
            Connection con = DriverManager.getConnection(conURL, user, pass);
            String query = "SELECT * FROM Events WHERE DateAndTime = ? AND Location = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, dateTime);
            pstmt.setString(2, location);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
        return false;
    }
    
    private boolean registerEvent(HttpServletRequest request) {
        try {
            // Get event details from request parameters
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String dateTime = request.getParameter("dateTime");
            String location = request.getParameter("location");
            int duration = Integer.parseInt(request.getParameter("duration"));
            int organizerId = Integer.parseInt(request.getParameter("organizerId"));
            
            // Insert event into the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/ASTU_StudentUnionDB";
            String user = "root";
            String pass = "Fahmi@12345";
            Connection con = DriverManager.getConnection(conURL, user, pass);
            String query = "INSERT INTO Events (Title, Description, DateAndTime, Location, Duration, Organizer) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, dateTime);
            pstmt.setString(4, location);
            pstmt.setInt(5, duration);
            pstmt.setInt(6, organizerId);
            
            int rowsAffected = pstmt.executeUpdate();
            
            con.close();
            
            if (rowsAffected > 0) {
                return true; // Event registration successful
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
        
        return false; // Event registration unsuccessful
    }
}
