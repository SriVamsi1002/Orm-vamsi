<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sprints</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        .sprint-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 30px;
        }

        .sprint-card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin: 10px;
            width: 250px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
            background-color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .sprint-card:hover {
            background-color: #f2f2f2;
        }

        .sprint-card h2 {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .sprint-card p {
            margin: 5px 0;
        }

        .sprint-card.active {
            border-color: #00cc66;
        }

        .sprint-card.completed {
            border-color: #ff3300;
        }

        .add-sprint-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Sprints</h1>

    <div class="sprint-container">
        <% 
        try {
            // JDBC code to fetch active sprints from the database
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Tarak_Sprints ");
            
            while (rs.next()) {
                int sprintId = rs.getInt("sprn_id");
                String sprintName = rs.getString("sprint_name");
                Date endDate = rs.getDate("sprn_enddate");
                boolean isActive = endDate.after(new java.util.Date());
                String status = isActive ? "Active" : "Completed";
        %>
                <div class="sprint-card <%= isActive ? "active" : "completed" %>"
                    onclick="window.location.href='sprint_details?sprintId=<%= sprintId %>'">
                    <h2>Sprint <%= sprintId %></h2>
                    <p><strong>Name:</strong> <%= sprintName %></p>
                    <p><strong>End Date:</strong> <%= endDate %></p>
                    <p><strong>Status:</strong> <%= status %></p>
                </div>
        <% 
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) { 
            e.printStackTrace();
        }
        %>
    </div>

    <a class="add-sprint-link" href="add_sprint">Add Sprint</a>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>
