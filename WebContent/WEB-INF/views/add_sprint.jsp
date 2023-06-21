<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Sprint</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>Create Sprint</h1>
        
        <form action="tasks" method="get">
            <div class="form-group">
                <label for="sprintId">Sprint ID:</label>
                <input type="text" class="form-control" id="sprintId" name="sprintId" required>
            </div>
            
            <div class="form-group">
                <label for="sprintMaster">Sprint Master:</label>
                <input type="text" class="form-control" id="sprintMaster" name="sprintMaster" required>
            </div>
            
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="text" class="form-control" id="startDate" name="startDate" required>
            </div>
            
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="text" class="form-control" id="endDate" name="endDate" required>
            </div>
            
            <div class="form-group">
                <label for="project">Project:</label>
                <select class="form-control" id="project" name="project" onchange="fetchModules()" required>
                    <% 
                    // JDBC code to fetch projects from the database dynamically
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;
                    String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
                    String user = "plf_training_admin";
                    String password = "pff123";
                    
                    try {
                        // Establish database connection
                        conn = DriverManager.getConnection(url, user, password);
                        
                        // Prepare the SQL statement
                        String projectQuery = "SELECT project_id, project_name FROM venkie_projects";
                        pstmt = conn.prepareStatement(projectQuery);
                        
                        // Execute the query
                        rs = pstmt.executeQuery();
                        
                        // Iterate through the result set and populate options in select tag
                        while (rs.next()) {
                            String projectId = rs.getString("project_id");
                            String projectName = rs.getString("project_name");
                    %>
                            <option value="<%= projectId %>"><%= projectName %></option>
                    <%
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        // Close database resources
                        try {
                            if (rs != null) rs.close();
                            if (pstmt != null) pstmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    %>
                </select>
            </div>
            
            <div class="form-group">
                <label for="modules">Modules:</label>
                <select class="form-control" id="modules" name="modules" >
                    <% 
                    // JDBC code to fetch modules based on the selected project
                    String selectedProject = request.getParameter("project");
                    if (selectedProject != null) {
                        try {
                            // Establish database connection
                            int pro_id = Integer.parseInt(selectedProject);
                            conn = DriverManager.getConnection(url, user, password);
                            // Prepare the SQL statement with a parameter
                            String moduleQuery = "SELECT module_id, module_name FROM venkie_modules WHERE project_id = ?";
                            pstmt = conn.prepareStatement(moduleQuery);
                            pstmt.setInt(1, pro_id);
                            
                            // Execute the query
                            rs = pstmt.executeQuery();
                            
                            // Iterate through the result set and populate options in select tag
                            while (rs.next()) {
                                String moduleId = rs.getString("module_id");
                                String moduleName = rs.getString("module_name");
                        %>
                                <option value="<%= moduleId %>"><%= moduleName %></option>
                        <%
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            // Close database resources
                            try {
                                if (rs != null) rs.close();
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    %>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Create Sprint</button>
        </form>
    </div>
</body>
</html>
