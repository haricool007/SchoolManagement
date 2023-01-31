<%@page import="EntityClasses.Student"%>
<%@page import="ServletClasses.StudentRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student Details</title>
</head>
<body align="center">
	<h1>Students Details</h1>
	
	<%Student s = (Student) session.getAttribute("hari");%>

	<table align="center" cellpadding="10px" border="2">

		<th>id</th>
		<th>name</th>
		<th>stream</th>
		<th>fees</th>

		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getStream()%></td>
			<td><%=s.getFees()%></td>
		</tr>

	</table> <br>
<button type="submit"><a href="Student.html"> Main Menu </a> </button> 
</body>
</html>