// EventDAO.java
package Admin;

import java.sql.*;

public class EventDAO{
    private Connection con;

    public EventDAO() {
        // Initialize database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/ASTU_StudentUnionDB";
            String user = "root";
            String pass = "Fahmi@12345";
            con = DriverManager.getConnection(conURL, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean registerUserForEvent(String username, int eventId) {
        try {
            // Insert registration information into database
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO UserEvents (UserID, EventID) VALUES ((SELECT UserID FROM Users WHERE Username = ?), ?)");
            pstmt.setString(1, username);
            pstmt.setInt(2, eventId);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // Check if registration was successful
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editEvent(int eventId, String title, String description, Timestamp dateTime, String location, int duration, String organizer) {
        try {
            // Update event information in the database
            PreparedStatement pstmt = con.prepareStatement("UPDATE Events SET Title = ?, Description = ?, DateAndTime = ?, Location = ?, Duration = ?, Organizer = ? WHERE EventID = ?");
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setTimestamp(3, dateTime);
            pstmt.setString(4, location);
            pstmt.setInt(5, duration);
            pstmt.setString(6, organizer);
            pstmt.setInt(7, eventId);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // Check if update was successful
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteEvent(int eventId) {
        try {
            // Delete event from the database
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Events WHERE EventID = ?");
            pstmt.setInt(1, eventId);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
                
            // Check if deletion was successful
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
