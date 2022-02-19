<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Home Page</title>
</head>
<body>
<div class="container">

	<h1 class="text-center m-4">Search home page :</h1>

	<div class="card mx-auto mt-5 bg-secondary" style="width: 50%;">
		<div class="card-body py-5">

			<h3 class="text-center text-white" style="text-transform: uppercase;">My Search</h3>

			<form action="search" class="mt-3">				<!-- // Putting action "search" for sending this request to this "search" handler  -->

				<div class="form-group">
					<input type="text" name="querybox" placeholder="Enter your search keyword" class="form-control" />
				</div>	<br>
				
				<div class="container text-center">
					<button class="btn btn-outline-light">Search</button>
				</div>

			</form>
		</div>
	</div>
</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>