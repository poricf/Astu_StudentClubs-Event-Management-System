<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Edited Successfully</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f6fc; /* Light blue background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        .container {
            background-color: #ffffff; /* White container background */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        
        h2 {
            color: #007bff; /* Blue header text */
        }
        
        p {
            color: #333; /* Dark text color */
            margin-bottom: 20px;
        }
        
        a {
            color: #007bff; /* Blue link color */
            text-decoration: none;
            font-weight: bold;
        }
        
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Event Edited Successfully!</h2>
        <p>Your changes have been saved.</p>
        <a href="ViewEvents">Back to Event List</a>
    </div>
</body>
</html>
