<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.nkxgen.spring.orm.model.Module" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="createModule">
<% Module m = (Module) request.getAttribute("mod"); %>
<table>
<tr>
<th style="padding-right: 10px;">Moule Id</th>
<th style="padding-right: 10px;">Module name</th>
<th style="padding-right: 10px;">Model desc</th>
<th style="padding-right: 10px;"> project id</th></tr>
<tr><td><input type="number" value=<%= m.getModl_id() %>></td>
<td><input type="text"  value=<%= m.getModl_name() %>></td>
<td><input type="text"  value=<%= m.getModl_desc() %>></td>
<td><input type="number"  value=<%= m.getModl_project_id() %>></td>
<tr><td><input type="number" value="2"></td>
<td><input type="text"  value="module-2"></td>
<td><input type="text"  value="Module-2 desc"></td>
<td><input type="number"  value="3"></td>
<tr><td><input type="number" value="3"></td>
<td><input type="text"  value="modukle3"></td>
<td><input type="text"  value="module3-desc"></td>
<td><input type="number"  value="1"></td>
<tr><td><input type="number" value="4"></td>
<td><input type="text"  value="module-4"></td>
<td><input type="text"  value="module-4 desc"></td>
<td><input type="number"  value="1"></td>
</tr>

</table> 
<input type="submit" value ="create module">
</form>
</body>
</html>
