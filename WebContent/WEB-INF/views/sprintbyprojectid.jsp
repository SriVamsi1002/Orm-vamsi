<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Productivity Monitor</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }

        .card {
            width: 80%;
            margin: 30px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .card:hover {
            background-color: #f5f5f5;
        }

        .card-header {
            font-weight: bold;
            margin-bottom: 10px;
        }

        .card-content {
            margin-bottom: 10px;
        }

        .back-button {
            background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
    <script>
        function redirectToSprintDetails(sprintId) {
            console.log(sprintId);
            console.log("chirulovesnagaraju");
            // Replace 'Mysprint' with the actual URL mapping for the Sprint details page in your application
            window.location.href = 'Mysprint?sprintId=' + sprintId;
        }

        window.addEventListener('DOMContentLoaded', () => {
            const cards = document.querySelectorAll('.card');
            cards.forEach((card) => {
                card.addEventListener('click', () => {
                    const sprintId = card.dataset.sprintId;
                    redirectToSprintDetails(sprintId);
                });
            });
        });
    </script>
</head>
<body>
    <h1>Sprint Details</h1>

    <c:forEach items="${sprintdto}" var="sprint">
        <div class="card" data-sprint-id="${sprint.sprn_id}">
            <div class="card-header">Sprint ID: ${sprint.sprn_id}</div>
            <div class="card-content">Sprint Name: ${sprint.sprint_name}</div>
            <div class="card-content">Sprint Master: ${sprint.sprn_master}</div>
            <div class="card-content">Sprint Module ID: ${sprint.sprn_modl_id}</div>
            <div class="card-content">Sprint Start Date: ${sprint.startDate}</div>
            <div class="card-content">Sprint End Date: ${sprint.sprn_enddate}</div>
            <div class="card-content">Sprint Project ID: ${sprint.proj_id}</div>
        </div>
    </c:forEach>

    <button class="back-button" onclick="history.back()">Back</button>
</body>
</html>
