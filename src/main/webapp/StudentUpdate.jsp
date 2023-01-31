<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="EntityClasses.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Student Details</title>
<link rel="stylesheet" href="Style1.css">
</head>
<body>
	<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("harish");
	EntityManager em = emf.createEntityManager();

	Student s = em.find(Student.class, id1);
	%>

	<h2>Update Student details</h2>
	<form id="login-form" action="studentUpdate" method="post">
		
		<p>
			<input type="text" class="data" name="id" value="<%=s.getId() %>"
				placeholder="Enter Student Id">
		</p>
		
		<p>
			<input type="text" class="data" name="name" value="<%=s.getName() %>"
				placeholder="Enter Student Name">
		</p>
		
		<p>
			<input type="text" class="data" name="stream" value="<%=s.getStream()%>"
				placeholder="Enter Stream">
		</p>
		<p>
			<input type="text" class="data" name="fees" value="<%=s.getFees()%>"
				placeholder="Enter Your fees">
		</p>
		<p>
			<input type="submit" class="data" name="submit">
		</p>
	</form>
</body>
</html>