<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Card Grid View with Bootstrap</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body, html {
            height: 100%;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
        .card {
            margin-bottom: 20px;
            background-color: #f8f9fa;
        }
        .card-title {
            padding: 10px;
            background-color: #e9ecef;
            margin-bottom: 0;
        }
        .card-columns {
            column-count: 3;
            column-gap: 20px;
            max-width: 600px;
            margin: 0 auto;
        }
        .btn-add-project {
            display: block;
            margin: 20px auto;
        }
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        .container {
            max-width: 900px;
            margin: 0 auto;
        }

        .card-columns {
            column-count: 3;
            column-gap: 20px;
        }

        .card {
            border: none;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card-title {
            background-color: #f8f9fa;
            color: #495057;
            font-size: 16px;
            padding: 10px;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            margin-bottom: 0;
        }

        .card-body {
            padding: 20px;
        }

        .card-text {
            color: #6c757d;
            font-size: 14px;
            margin-bottom: 0;
        }

        .btn-add-project {
            display: block;
            margin: 20px auto;
            border-radius: 8px;
        }
    </style>
</head>
<body>
        <div class="container">
            <div class="card-columns">
           
            <div class="card clickable-row" onclick="location.href='projectDetails'">
                    <h5 class="card-title">View Projects</h5>
                    <div class="card-body">
                        <p class="card-text"></p>
                    </div>
                </div>
            </div>
        </div>
    <button class="btn btn-primary btn-add-project" type="button">Add Project</button>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
