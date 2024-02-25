package User;

import java.sql.*;

public class LoginDao {
    public static boolean validate(String User_name, String Pass_word) {
        boolean status = false;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection URL for MySQL
            String conURL = "jdbc:mysql://localhost:3306/ASTU_StudentUnionDB";

            // MySQL username and password
            String user = "root";
            String pass = "Fahmi@12345";

            Connection con = DriverManager.getConnection(conURL, user, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM plogindetails WHERE user_name=? AND pass_word=?");
            ps.setString(1, User_name);
            ps.setString(2, Pass_word);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
