<%@page import="EntityClasses.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Teacher Details</title>
<link rel="stylesheet" href="Style1.css">
</head>
<body>
	<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("harish");
	EntityManager em = emf.createEntityManager();

	Teacher t = em.find(Teacher.class, id1);
	%>

	<form id="login-form" action="updateTeacher" method="post">
	<h2>Update Teacher Deatils</h2>
	<p> <input type="text" value="<%=t.getId()%>" class="data" name="id" placeholder="Enter ID"></p>
	<p> <input type="text" value="<%=t.getName()%>" class="data" name="name" placeholder="Enter Teacher Name"></p>
	<p><input type="text"  value="<%=t.getSubject()%>" class="data" name="sub" placeholder="Enter Subject"></p>
	<p><input type="text"  value="<%= t.getSal()%>" class="data" name="sal" placeholder="Enter Salary Ammount"></p>
	<p><input type="submit" class="data" name="submit"></p>
	
	</form>
</body>
</html>