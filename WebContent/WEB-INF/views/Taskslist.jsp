<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tasks</title>
</head>
<body>
    <h1>Tasks</h1>
    <table>
        <tr>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Task Creation Date</th>
            <th>Task Type</th>
            <th>Task Category</th>
            <th>Task Description</th>
            <th>Task Creator</th>
            <th>Number of Hours Required</th>
            <th>Task Expected Date</th>
            <th>Task Completed Date</th>
            <th>Task Supervisor</th>
            <th>Task Remarks</th>
            <th>Task Status</th>
            <th>Project</th>
            <th>Module</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.taskId}</td>
                <td>${task.taskName}</td>
                <td>${task.taskCreationDateTime}</td>  
                <td>${task.taskType}</td>
                <td>${task.taskCategory}</td>
                <td>${task.taskDescription}</td>
                <td>${task.taskCreator.userId}</td>
                <td>${task.numberOfHoursRequired}</td>
                <td>${task.taskExpectedDateTime}</td>
                <td>${task.taskCompletedDateTime}</td>
                <td>${task.taskSupervisor.userId}</td>
                <td>${task.taskRemarks}</td>
                <td>${task.taskStatus}</td>
                <td>${task.project.projectId}</td>
                <td>${task.module.moduleId}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
