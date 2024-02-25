<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Event</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        form {
            background-color: #e6f7ff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        
        h2 {
            text-align: center;
            color: #333;
        }
        
        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        
        input[type="text"],
        input[type="datetime-local"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            font-size: 14px;
        }
        
        textarea {
            height: 100px;
        }
        
        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <form action="UpdateEvent" method="post">
        <h2>Edit Event</h2>
        <label for="eventId">Event ID:</label>
        <input type="text" id="eventId" name="eventId" readonly>
        
        <label for="title">Title:</label>
        <input type="text" id="title" name="title">
        
        <label for="description">Description:</label>
        <textarea id="description" name="description"></textarea>
        
        <label for="dateTime">Date and Time:</label>
        <input type="datetime-local" id="dateTime" name="dateTime">
        
        <label for="location">Location:</label>
        <input type="text" id="location" name="location">
        
        <label for="duration">Duration (in hours):</label>
        <input type="number" id="duration" name="duration">
        
        <label for="organizer">Organizer:</label>
        <input type="text" id="organizer" name="organizer">
        
        <input type="submit" value="Submit">
    </form>

    <script>
        // Autofill the eventId field with the value from URL parameter
        const urlParams = new URLSearchParams(window.location.search);
        const eventId = urlParams.get('eventId');
        document.getElementById('eventId').value = eventId;
    </script>
</body>
</html>
