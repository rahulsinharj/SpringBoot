<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
</head>
<body>

<h2>This is my Home Page !</h2>

	<%
		String n = (String) request.getAttribute("name");
		Integer ph = (Integer) request.getAttribute("phone");
	%>

<h2>
			Name is :  <%=n%>					<!-- // Not recommended to fetch data from above request.getAttribute() way, and printing them use this JSP way -->
	<br>	PhoneNum is :  <%=ph%>
</h2>

	<hr> Name is : ${name}							<!-- // Better to use JSTL way  -->

	<br> Phone Number is : ${phone}

	<br> Current Data and Time is : ${datetime}

	<br> Marks are : ${marks}

	<hr>
	<c:forEach var="m" items="${marks}">
		<h3>${m}</h3>
	</c:forEach>


	<br> Thank you...

</body>
</html>