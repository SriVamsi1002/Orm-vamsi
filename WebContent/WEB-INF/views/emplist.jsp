<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="com.nkxgen.spring.orm.model.Employee,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees List through Spring JDBC Template</title>
</head>
 <BODY BGCOLOR="yellow">
       <H1>Employees List through Spring JDBC Template </H1>

      <TABLE BORDER="1">
      <TR>
      <TH>Emp No</TH>
      <TH>Name</TH>
      <TH>Job</TH>
      <TH>Salary</TH>
      <TH>Dept No</TH>
      </TR>
      <% 
      	
        List<Employee> elist=(List<Employee>)request.getAttribute("elist");
		for(Employee e:elist){
	  %>
      	<TR>
       		  <TD> <%= e.getEmpNo() %></td>
     		  <TD> <%= e.getEName() %></TD>
      		  <TD> <%= e.getJob() %></TD>
     		  <TD> <%= e.getSalary() %></TD>
     		  <TD> <%= e.getDeptNo() %></TD>
      </TR>
      <% 
      	} 
      %>
     </TABLE>
     </BODY>
</html>