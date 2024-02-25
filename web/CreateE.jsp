<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Event</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap">

    <style>
        body {
            padding-top: 56px; /* Adjusted to accommodate fixed-top navbar */
            font-family: 'Balsamiq Sans', cursive;
            background: url('images/BG33.jpg') center center fixed;
            background-color: #f8f9fa; /* Bootstrap background color */
           
        }

        h2 {
            text-align: center;
            margin-top: 80px;
            margin-bottom: 30px;
            color: #007bff; /* Bootstrap primary color */
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff; /* White background */
            padding: 20px;
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Box shadow for depth */
        }

        label {
            font-weight: bold;
        }

        textarea {
            width: 100%;
        }

        input[type="datetime-local"],
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 5px; /* Rounded corners */
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        p.error-message {
            color: red;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Event Portal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="AdminEvent.html">Home</a>
                    </li>
                    
                           
                </ul>
                
            </div>
        </div>
    </nav>

    <h2>Create Event</h2>
    <!-- Form to create event -->
    <form method="post" action="CreateEvent">
        <!-- Event details inputs -->
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" class="form-control" required>
        </div>

        <!-- Description input -->
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" class="form-control" rows="4" cols="50"></textarea>
        </div>

        <!-- Date and time input -->
        <div class="form-group">
            <label for="dateTime">Date and Time:</label>
            <input type="datetime-local" id="dateTime" name="dateTime" class="form-control" required>
        </div>

        <!-- Location input -->
        <div class="form-group">
            <label for="location">Location:</label>
            <input type="text" id="location" name="location" class="form-control" required>
        </div>

        <!-- Duration input -->
        <div class="form-group">
            <label for="duration">Duration (in hours):</label>
            <input type="number" id="duration" name="duration" class="form-control" required>
        </div>

        <!-- Organizer ID input -->
        <div class="form-group">
            <label for="organizerId">Organizer ID:</label>
            <input type="number" id="organizerId" name="organizerId" class="form-control" required>
        </div>

        <!-- Error message section -->
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
                <p class="error-message"><%= errorMessage %></p>
        <%
            }
        %>

        <!-- Submit button -->
        <input type="submit" value="Add Event" class="btn btn-primary">
    </form>
</body>
</html>
