<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Club Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .club-list {
            margin-top: 20px;
        }

        .club-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin-bottom: 15px;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        .club-name {
            font-size: 20px;
            font-weight: bold;
        }

        .member-count {
            color: #555;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>Club Information</h1>
        <div class="club-list">
            <c:forEach var="club" items="${clubData}">
                <div class="club-card">
                    <p class="club-name">${club.key}</p>
                    <p class="member-count">Members: ${club.value}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</body>

</html>
