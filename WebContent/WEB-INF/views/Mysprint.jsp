<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sprint Details and Progress</title>
</head>
<body>
    <h1>Sprint Details and Progress</h1>
    <table>
        <tr>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${sprintdto}" var="task">
            <tr>
                <td>${task.taskId}</td>
                <td>${task.taskName}</td>
                <td>${task.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
