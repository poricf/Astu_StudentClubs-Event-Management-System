<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.*" %>
<html>
<head>
    <title>Event Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h2, h3, p {
            text-align: center;
            color: #333;
        }

        form {
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="submit"] {
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <%!
        // Declaration of session object
        HttpSession session;
    %>
    <%
        // Get the session object
        session = request.getSession();
        
        // Check if the user is logged in
        String username = (String) session.getAttribute("username");
        if (username == null) {
            // If not logged in, redirect to the login page
            response.sendRedirect("Plogin.html");
            return;
        }
        
        // If logged in, proceed with event registration
        String eventId = request.getParameter("eventId");
        String eventName = request.getParameter("title");
    %>
    <h2>Welcome <%= username %>!</h2>
    <h3>Event Registration</h3>
    <p>You are registering for the event:</p>
    <p>Event ID: <%= eventId %></p>
    <p>Event Name: <%= eventName %></p>
    <form method="post" action="RegisterEvent">
        <!-- Add form fields for event registration -->
        <input type="hidden" name="eventId" value="<%= eventId %>">
        <input type="hidden" name="eventName" value="<%= eventName %>">
        <input type="submit" value="Register">
    </form>
</body>
</html>
