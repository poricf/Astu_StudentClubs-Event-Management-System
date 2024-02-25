package Admin;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class ViewEvents extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("<script>");
        out.println("function redirectToEventRegistration(eventId, title) {");
        out.println("  var encodedTitle = encodeURIComponent(title);");
        out.println("  window.location.href = 'EventReg.jsp?eventId=' + eventId + '&title=' + encodedTitle;");
        out.println("}");
        out.println("function deleteEvent(eventId, title) {");
        out.println("  var confirmation = confirm('Are you sure you want to delete the event ' + title + '?');");
        out.println("  if (confirmation) {");
        out.println("    // Forward to servlet for deleting the event");
        out.println("    window.location.href = 'DeleteEvent?eventId=' + eventId;");
        out.println("  }");
        out.println("}");
        out.println("function editEvent(eventId, title) {");
        out.println("  window.location.href = 'EditEvent.jsp?eventId=' + eventId;");
        out.println("}");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection URL for MySQL
            String conURL = "jdbc:mysql://localhost:3306/ASTU_StudentUnionDB";

            // MySQL username and password
            String user = "root";
            String pass = "Fahmi@12345";

            Connection con = DriverManager.getConnection(conURL, user, pass);

            response.setContentType("text/html");
            Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery("SELECT e.EventID, e.Title, e.Description, e.DateAndTime, e.Location, e.Duration, c.Name AS Organizer FROM Events e INNER JOIN Clubs c ON e.Organizer = c.ClubID");

            out.println("<center><h1>Event Details</h1></center>");
            out.println("<br>");
            out.println("<div>");
            out.println("<center>");
            out.println("<table border=1 width=80%>");
            out.println("<tr><th>EventID</th><th>Title</th><th>Description</th><th>Date and Time</th><th>Location</th><th>Duration</th><th>Organizer</th><th>Actions</th></tr>"); 
            while (rs.next()) {
                int eventId = rs.getInt("EventID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                Timestamp dateTime = rs.getTimestamp("DateAndTime");
                String location = rs.getString("Location");
                int duration = rs.getInt("Duration");
                String organizer = rs.getString("Organizer");

                // Render table row with data
                out.println("<tr>");
                out.println("<td>" + eventId + "</td>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + description + "</td>");
                out.println("<td>" + dateTime + "</td>");
                out.println("<td>" + location + "</td>");
                out.println("<td>" + duration + "</td>");
                out.println("<td>" + organizer + "</td>");
                out.println("<td>");
                out.println("<button style='background-color: lightgreen;' onclick=\"editEvent(" + eventId + ", '" + title + "')\">Edit</button>");
                // Red Delete button
                out.println("<button style='background-color: lightcoral;' onclick=\"deleteEvent(" + eventId + ", '" + title + "')\">Delete</button>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>"); 
            out.println("</center>");
            out.println("</div>");
            con.commit();
            con.close();
            out.println("</body>");
            out.println("</html>");
        } catch (Exception exe) {
            System.out.println("Exception caught" + exe);
        }
    }
}
