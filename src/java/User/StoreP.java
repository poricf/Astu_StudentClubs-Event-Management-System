package User;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class StoreP extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        // Fetching data from Psignup.html from user
        String up = request.getParameter("Pusername");
        String pp = request.getParameter("Ppassword");
        String cp = request.getParameter("Cpassword");
        String name = request.getParameter("Pname");

        // Assign to another strings
        String a1 = up;
        String a2 = pp;
        String a3 = cp;
        String a4 = name;

        if (a2.equals(a3)) {
            // Connection & storing into Database
            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                out.println("<p>JDBC driver loaded successfully</p>");

                // Connection URL for MySQL
                String conURL = "jdbc:mysql://localhost:3306/ASTU_StudentUnionDB";

                // MySQL username and password
                String user = "root";
                String pass = "Fahmi@12345";
                
                // Attempting to establish connection
                out.println("<p>Attempting to connect to the database...</p>");
                try ( // Create connection
                        Connection con = DriverManager.getConnection(conURL, user, pass)) {
                    out.println("<p>Connected to database successfully</p>");
                    
                    // SQL statement
                    String query = "INSERT INTO plogindetails (user_name, pass_word, name) VALUES (?, ?, ?)";
                    PreparedStatement stmt = con.prepareStatement(query);
                    stmt.setString(1, a1);
                    stmt.setString(2, a2);
                    stmt.setString(3, a4);
                    int rowsInserted = stmt.executeUpdate();

                    if (rowsInserted > 0) {
                        out.println("<center><h1>Data inserted successfully</h1></center>");
                        RequestDispatcher rd = request.getRequestDispatcher("Plogin.html");
                        rd.forward(request, response);
                    } else {
                        out.println("<center><h1>Failed to insert data</h1></center>");
                    }
                } catch (SQLException e) {
                    out.println("<p>Failed to connect to database</p>");
                    out.println("<p>Error message: " + e.getMessage() + "</p>");
                    e.printStackTrace(); // Log the exception for debugging
                }
            } catch (ClassNotFoundException exe) {
                out.println("<p>Failed to load MySQL JDBC driver</p>");
                exe.printStackTrace(); // Log the exception for debugging
            }
        } else {
            out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1></center>");
            RequestDispatcher rd = request.getRequestDispatcher("Psignup.html");
            rd.include(request, response);
        }
    }
}
