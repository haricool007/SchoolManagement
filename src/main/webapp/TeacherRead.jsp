<%@page import="EntityClasses.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Teacher Detail</title>
</head>
<body align="center">
	<h1>Teacher Detail</h1>

	<%Teacher t = (Teacher) session.getAttribute("hari");%>
	
	<table align="center" cellpadding="10px" border="2">
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Subject</th>
		<tr>
			<td><%=t.getId() %></td>
			<td><%=t.getName() %></td>
			<td><%=t.getSal()%></td>
			<td><%=t.getSubject()%></td>
		</tr>
	</table> <br>
 <button type="submit"><a href="Teacher.html"> Main Menu </a> </button> 
</body>
</html>