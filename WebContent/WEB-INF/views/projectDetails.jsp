<!DOCTYPE html>
<html>
<head>
    <title>Productivity Monitor</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        .card {
            width: 400px;
            margin: 30px auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        .card-header {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
            text-align: center;
        }

        .card-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }

        .card-label {
            font-weight: bold;
        }

        .buttons-container {
            text-align: center;
            margin-top: 20px;
        }

        .button {
            background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<div class="card">
    <div class="card-header">Project Details</div>
    <div class="card-row">
        <span class="card-label">Project ID:</span>
        <span>${projectDto.projectId}</span>
    </div>
    <div class="card-row">
        <span class="card-label">Project Name:</span>
        <span>${projectDto.projectName}</span>
    </div>
    <div class="card-row">
        <span class="card-label">Project Description:</span>
        <span>${projectDto.projectDescription}</span>
    </div>
    <div class="card-row">
        <span class="card-label">Project Start Date:</span>
        <span>${projectDto.projectStartDate}</span>
    </div>
    <div class="card-row">
        <span class="card-label">Project Manager:</span>
        <span>${projectDto.projectManagerName}</span>
    </div>
    <div class="card-row">
        <span class="card-label">Project Status:</span>
        <span>${projectDto.projectStatus}</span>
    </div>
    <div class="card-row">
        <span class="card-label">Project Last Updated Date:</span>
        <span>${projectDto.projectLastUpdatedDate}</span>
    </div>
</div>

<div class="buttons-container">
    <button class="button" onclick="calls()">Modules</button>
    <button class="button" onclick="location.href='resources1.jsp'">Resources</button>
    <button class="button" onclick="call()">Sprints</button>
    <button class="button" onclick="goBack()">Back</button>
</div>

<script>
    function calls() {
        window.location.href = 'moduleDetailsByProjId?projectId=' + ${projectDto.projectId};
    }

    function call() {
        window.location.href = 'sprintbyprojectid?projectId=' + ${projectDto.projectId};
    }

    function goBack() {
        window.history.back(); // Go back to the previous page
    }
</script>

</body>
</html>
