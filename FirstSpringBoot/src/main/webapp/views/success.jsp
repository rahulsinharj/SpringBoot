<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
	<h2 class="text-center">${header1}</h2>
	<p class="text-center">${description2} </p>
	<h1 style="color: green" class="text-center"> ${userResponse} </h1>	 <hr>

<!-- // below fetching will only work when we have set uname,uemail,upassword attributes directly into Model/ModelView object in Controller class -->
<%-- <h2> Welcome, ${uname} ! </h2>
	 <h2> Your Email Address is : ${uemail} </h2>
	 <h2> Your password is "${upassword}" , try to secure the password. </h2>
 --%>
 
<!-- // But when in Model/ModelView object, we have set only USER entity obj, then we will have to fetch user obj properties by putting dot   -->
 
	<h2> Welcome, ${user.userName} ! </h2>
	<h2> Your Email Address is : ${user.userEmail} </h2>
	<h2> Your password is "${user.userPassword}" , try to secure the password. </h2>
 
</body>
</html>
